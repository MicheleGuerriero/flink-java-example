package it.polimi.uml2flink.example1.datatypes;

/**
 * Created by miik on 01/11/17.
 */
public class TransactionCount {

    public TransactionCount() {

    }

    public String getDataSubject() {
        return dataSubject;
    }

    public void setDataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public Integer getnTransactions() {
        return nTransactions;
    }

    public void setnTransactions(Integer nTransactions) {
        this.nTransactions = nTransactions;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public TransactionCount(String dataSubject,
                            Integer nTransactions,
                            Long eventTime){
        this.dataSubject = dataSubject;
        this.nTransactions = nTransactions;
        this.eventTime = eventTime;
    }

    private String dataSubject;

    private Integer nTransactions;

    private Long eventTime;
}
