public class Main {
    public static void main(String[] args) {
        // Step 1: Create the Simulator (Singleton)
        Simulator simulator = Simulator.getInstance();

        // Step 2: Set the Protocol Factory (e.g., IPv4Factory or IPv6Factory)
        ProtocolFactory protocolFactory = new IPv4Factory();
        simulator.setProtocolFactory(protocolFactory);

        // Step 3: Build the Network Topology
        NetworkTopologyBuilder topologyBuilder = new StarTopologyBuilder();

        // Add nodes to the topology
        Node node1 = new Node("Node1");
        Node node2 = new Node("Node2");
        topologyBuilder.addNode(node1);
        topologyBuilder.addNode(node2);

        // Add links to the topology
        Link ethernetLink = protocolFactory.createLink();
        topologyBuilder.addLink(ethernetLink);

        // Build the topology
        simulator.buildTopology(topologyBuilder);

        // Step 4: Set up the Packet Handler (Chain of Responsibility)
        PacketHandler routingHandler = new RoutingHandler();
        PacketHandler filteringHandler = new FilteringHandler();
        routingHandler.setNextHandler(filteringHandler);
        simulator.setPacketHandler(routingHandler);

        // ADDDDDDDDD STUFF HEREEEEEEEEEEEEEEEEEEEEEEEEEE
// Create packets
        Packet packet1 = new Packet("Node1", "Node2", "Hello, Node2!");
        Packet packet2 = new Packet("Node2", "Node3", "Hi, Node3!");
        Packet packet3 = new Packet("Node3", "Node1", "Greetings, Node1!");

// Create network interfaces
        NetworkInterface ethernetInterface = new EthernetLink(); // Ethernet interface
        NetworkInterface wifiInterface = new WiFiLink();         // WiFi interface

// Create traffic commands
        TrafficCommand sendPacket1 = new SendPacketCommand(packet1, ethernetInterface);
        TrafficCommand sendPacket2 = new SendPacketCommand(packet2, wifiInterface);
        TrafficCommand sendPacket3 = new SendPacketCommand(packet3, ethernetInterface);

// Add traffic commands to the simulator
        simulator.addTrafficCommand(sendPacket1);
        simulator.addTrafficCommand(sendPacket2);
        simulator.addTrafficCommand(sendPacket3);

        // Step 6: Add Observers (Observer Pattern)
        Observer loggingService = new LoggingService();
        simulator.addObserver(loggingService);

        // Step 7: Run the Simulation
        simulator.runSimulation();
    }
}