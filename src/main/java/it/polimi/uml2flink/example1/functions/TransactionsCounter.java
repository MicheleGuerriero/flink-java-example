package it.polimi.uml2flink.example1.functions;

import it.polimi.uml2flink.example1.datatypes.FinancialTransaction;
import it.polimi.uml2flink.example1.datatypes.TransactionCount;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.windowing.RichWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * Created by miik on 01/11/17.
 */
public class TransactionsCounter extends RichWindowFunction<FinancialTransaction, TransactionCount, String, TimeWindow> {

    @Override
    public void open(Configuration parameters) throws Exception {

    }

    @Override
    public void apply(String s, TimeWindow timeWindow, Iterable<FinancialTransaction> iterable, Collector<TransactionCount> collector) throws Exception {

        Integer count = 0;
        for(FinancialTransaction t: iterable){
            count = count + 1;
        }
        collector.collect(new TransactionCount(s, count, timeWindow.getEnd()));

    }

}
