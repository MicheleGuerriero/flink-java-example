package it.polimi.uml2flink.example1.datatypes;

/**
 * Created by miik on 01/11/17.
 */
public class TotalExpense {

    public TotalExpense() {

    }

    public String getDataSubject() {
        return dataSubject;
    }

    public void setDataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer nTransactions) {
        this.amount = nTransactions;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public TotalExpense(String dataSubject,
                        Integer amount,
                        Long eventTime){
        this.dataSubject = dataSubject;
        this.amount = amount;
        this.eventTime = eventTime;
    }

    private String dataSubject;

    private Integer amount;

    private Long eventTime;
}
