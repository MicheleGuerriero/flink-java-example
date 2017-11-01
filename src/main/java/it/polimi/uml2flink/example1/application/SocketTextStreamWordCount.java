package it.polimi.uml2flink.example1.application;


import it.polimi.uml2flink.example1.datatypes.FinancialTransaction;
import it.polimi.uml2flink.example1.datatypes.TopConsumersCount;
import it.polimi.uml2flink.example1.datatypes.TotalExpense;
import it.polimi.uml2flink.example1.functions.ExpensesCalculator;
import it.polimi.uml2flink.example1.functions.TopConsumersCounter;
import it.polimi.uml2flink.example1.functions.TransactionParser;
import it.polimi.uml2flink.example1.functions.TransactionsCounter;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

public class SocketTextStreamWordCount {

	public static void main(String[] args) throws Exception {

		if (args.length != 2){
			System.err.println("USAGE:\nSocketTextStreamWordCount <hostname> <port>");
			return;
		}

		String hostName = args[0];
		Integer port = Integer.parseInt(args[1]);

		final StreamExecutionEnvironment env = StreamExecutionEnvironment
				.getExecutionEnvironment();

		env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

		DataStream<String> rawTransactions = env.socketTextStream(hostName, port);

		DataStream<FinancialTransaction> transactions = rawTransactions.map(new TransactionParser());

		DataStream<TotalExpense> totalExpenses= transactions
				.keyBy("dataSubject")
				.timeWindow(Time.minutes(5))
				.apply(new ExpensesCalculator())
				.setParallelism(1);

		DataStream<TotalExpense> nTransactions = transactions
				.keyBy("dataSubject")
				.timeWindow(Time.minutes(5))
				.apply(new TransactionsCounter())
				.setParallelism(1);

		DataStream<TopConsumersCount> topConsumers = totalExpenses
				.keyBy("dataSUbject")
				.timeWindow(Time.minutes(30))
				.apply(new TopConsumersCounter())
				.setParallelism(1);

		totalExpenses
				.keyBy("dataSubject")
				.writeAsText("/home/utente/totalExpenses.txt")
				.setParallelism(1);

		nTransactions
				.keyBy("dataSubject")
				.writeAsText("/home/utente/nTransactions.txt")
				.setParallelism(1);

		topConsumers
				.writeAsText("/home/utente/topConsumers.txt");


		env.execute();
	}
}
