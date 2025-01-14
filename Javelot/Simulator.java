import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static Simulator instance;
    private ProtocolFactory protocolFactory;
    private List<TrafficCommand> trafficQueue = new ArrayList<>();
    private PacketHandler packetHandler;
    private NetworkTopology topology;
    private List<Observer> observers = new ArrayList<>();

    private Simulator() {}

    public static Simulator getInstance() {
        if (instance == null) {
            instance = new Simulator();
        }
        return instance;
    }

    public void setProtocolFactory(ProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public void addTrafficCommand(TrafficCommand command) {
        trafficQueue.add(command);
    }

    public void setPacketHandler(PacketHandler handler) {
        this.packetHandler = handler;
    }

    public void buildTopology(NetworkTopologyBuilder builder) {
        topology = builder.build();
    }

    public void runSimulation() {
        System.out.println("Simulation started...");

        // Execute all traffic commands
        for (TrafficCommand command : trafficQueue) {
            command.execute();
        }

        System.out.println("Simulation completed.");
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }


}