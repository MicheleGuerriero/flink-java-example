package it.polimi.uml2flink.example1.datatypes;

/**
 * Created by miik on 01/11/17.
 */
public class FinancialTransaction {

    public FinancialTransaction() {

    }

    public FinancialTransaction(String transactionId,
                                String dataSubject,
                                String recipient,
                                Long eventTime,
                                Integer amount) {
        this.transactionId = transactionId;
        this.dataSubject = dataSubject;
        this.recipient = recipient;
        this.eventTime = eventTime;
        this.amount = amount;
    }

    private String transactionId;

    private String dataSubject;

    private String recipient;

    private Long eventTime;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDataSubject() {
        return dataSubject;
    }

    public void setDataSubject(String dataSubject) {
        this.dataSubject = dataSubject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    private Integer amount;

}
