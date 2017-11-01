package it.polimi.uml2flink.example1.functions;

import it.polimi.uml2flink.example1.datatypes.FinancialTransaction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.configuration.Configuration;

/**
 * Created by miik on 01/11/17.
 */
public class TransactionParser extends RichMapFunction<String, FinancialTransaction> {

    @Override
    public void open(Configuration parameters) throws Exception {

    }

    @Override
    public FinancialTransaction map(String s) throws Exception {
        String[] fields = s.split(",");
        return new FinancialTransaction(
                fields[0],
                fields[1],
                fields[2],
                Long.parseLong(fields[3]),
                Integer.parseInt(fields[4]));
    }
}
