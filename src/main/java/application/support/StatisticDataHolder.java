package application.support;

public class StatisticDataHolder {
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public StatisticDataHolder(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "StatisticDataHolder{" +
                "event='" + event + '\'' +
                '}';
    }
}
