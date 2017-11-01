package it.polimi.uml2flink.example1.functions;

import it.polimi.uml2flink.example1.datatypes.TopConsumersCount;
import it.polimi.uml2flink.example1.datatypes.TotalExpense;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.windowing.RichAllWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miik on 01/11/17.
 */
public class TopConsumersCounter extends RichAllWindowFunction<TotalExpense, TopConsumersCount, TimeWindow> {

    @Override
    public void open(Configuration parameters) throws Exception {

    }

    @Override
    public void apply(TimeWindow timeWindow, Iterable<TotalExpense> iterable, Collector<TopConsumersCount> collector) throws Exception {

        Map<String, Integer> partialSum = new HashMap<String, Integer>();
        Integer count = 0;

        for(TotalExpense t: iterable){
            if(partialSum.containsKey(t.getDataSubject())){
                partialSum.put(t.getDataSubject(), partialSum.get(t.getDataSubject()) + t.getAmount());
            } else {
                partialSum.put(t.getDataSubject(), t.getAmount());
            }
        }

        for(String ds: partialSum.keySet()) {
            if(partialSum.get(ds) > 1000) {
                count = count + 1;
            }
        }

        collector.collect(new TopConsumersCount(count, timeWindow.getEnd()));
    }
}
