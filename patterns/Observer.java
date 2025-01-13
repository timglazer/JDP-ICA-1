import java.util.List;
import java.util.ArrayList;

// Observer Interface
interface Observer {
    void update(String event);
}

// Concrete Observers
class Logger implements Observer {
    @Override
    public void update(String event) {
        System.out.println("Logger recorded event: " + event);
    }
}

class StatisticsCollector implements Observer {
    private int packetsSent = 0;
    private int packetsLost = 0;

    public void recordSent() {
        packetsSent++;
    }

    public void recordLost() {
        packetsLost++;
    }

    @Override
    public void update(String event) {
        if (event.contains("lost")) {
            recordLost();
        } else if (event.contains("sent")) {
            recordSent();
        }
        System.out.println("Statistics updated: " + event);
    }

    public void printReport() {
        System.out.println("Packets Sent: " + packetsSent);
        System.out.println("Packets Lost: " + packetsLost);
    }
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String event);
}

// Concrete Subject
class NetworkDevice implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public void sendPacket(String packetContent) {
        System.out.println("Device sending packet: " + packetContent);
        notifyObservers("Packet sent: " + packetContent);
    }

    public void losePacket(String packetContent) {
        System.out.println("Device lost packet: " + packetContent);
        notifyObservers("Packet lost: " + packetContent);
    }
}

// Demonstration
class ObserverDemo {
    public static void main(String[] args) {
        String packetContent = "Observer Pattern Packet";
        NetworkDevice device = new NetworkDevice();

        // Adding observers
        Logger logger = new Logger();
        StatisticsCollector stats = new StatisticsCollector();

        device.addObserver(logger);
        device.addObserver(stats);

        // Simulate network events
        device.sendPacket(packetContent);
        device.losePacket(packetContent);

        // Print statistics
        stats.printReport();
    }
}
