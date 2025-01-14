public class Event {
    private long time;
    private Runnable action;

    public Event(long time, Runnable action) {
        this.time = time;
        this.action = action;
    }

    @Override
    public String toString() {
        return "Event{" +
                "time=" + time +
                ", action=" + action +
                '}';
    }
}