public class LoggingService implements Observer {
    @Override
    public void update(Event event) {
        System.out.println("LoggingService: Event logged - " + event);
    }
}