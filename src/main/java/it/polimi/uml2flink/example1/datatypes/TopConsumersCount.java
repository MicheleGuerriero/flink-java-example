package it.polimi.uml2flink.example1.datatypes;

/**
 * Created by miik on 01/11/17.
 */
public class TopConsumersCount {

    private  Integer nTopConsumers;
    private Long eventTime;

    public TopConsumersCount() {

    }

    public Integer getnTopConsumers() {
        return nTopConsumers;
    }

    public void setnTopConsumers(Integer nTopConsumers) {
        this.nTopConsumers = nTopConsumers;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public TopConsumersCount(Integer nTopConsumers,
                             Long eventTime) {
        this.nTopConsumers = nTopConsumers;
        this.eventTime = eventTime;
    }
}
