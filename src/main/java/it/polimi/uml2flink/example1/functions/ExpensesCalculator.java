package it.polimi.uml2flink.example1.functions;

import it.polimi.uml2flink.example1.datatypes.FinancialTransaction;
import it.polimi.uml2flink.example1.datatypes.TotalExpense;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.windowing.RichWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class ExpensesCalculator extends RichWindowFunction<FinancialTransaction, TotalExpense, String, TimeWindow> {

    @Override
    public void open(Configuration parameters) throws Exception {

    }

    @Override
    public void apply(String s, TimeWindow timeWindow, Iterable<FinancialTransaction> iterable, Collector<TotalExpense> collector) throws Exception {
        Integer sum = 0;
        for(FinancialTransaction t: iterable){
            sum = sum + t.getAmount();
        }
        collector.collect(new TotalExpense(s, sum, timeWindow.getEnd()));
    }

}
