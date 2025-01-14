public class Main {
    public static void main(String[] args) {
        // Creation of the simulator (Singleton)
        Simulator simulator = Simulator.getInstance();

        // Setting the protocol factory (e.g., IPv4Factory or IPv6Factory)
        ProtocolFactory protocolFactory = new IPv4Factory();
        simulator.setProtocolFactory(protocolFactory);

        // Building the network topology
        NetworkTopologyBuilder topologyBuilder = new StarTopologyBuilder();

        // Adding nodes to the network topology
        Node node1 = new Node("Node1");
        Node node2 = new Node("Node2");
        topologyBuilder.addNode(node1);
        topologyBuilder.addNode(node2);

        // Adding links to the network topology
        Link ethernetLink = protocolFactory.createLink();
        topologyBuilder.addLink(ethernetLink);

        // Build the network topology
        simulator.buildTopology(topologyBuilder);

        // Setting up the packet handler (Chain of Responsibility)
        PacketHandler routingHandler = new RoutingHandler();
        PacketHandler filteringHandler = new FilteringHandler();
        routingHandler.setNextHandler(filteringHandler);
        simulator.setPacketHandler(routingHandler);


        // Creating packets
        Packet packet1 = new Packet("Node1", "Node2", "Hello, Node2!");
        Packet packet2 = new Packet("Node2", "Node3", "Hi, Node3!");
        Packet packet3 = new Packet("Node3", "Node1", "Greetings, Node1!");

        // Creating network interfaces
        NetworkInterface ethernetInterface = new EthernetLink(); // Ethernet interface
        NetworkInterface wifiInterface = new WiFiLink();         // WiFi interface

        // Creating traffic commands
        TrafficCommand sendPacket1 = new SendPacketCommand(packet1, ethernetInterface);
        TrafficCommand sendPacket2 = new SendPacketCommand(packet2, wifiInterface);
        TrafficCommand sendPacket3 = new SendPacketCommand(packet3, ethernetInterface);

        // Adding traffic commands to the simulator
        simulator.addTrafficCommand(sendPacket1);
        simulator.addTrafficCommand(sendPacket2);
        simulator.addTrafficCommand(sendPacket3);

        // Adding Observers (Observer Pattern)
        Observer loggingService = new LoggingService();
        simulator.addObserver(loggingService);

        // Running the Simulation
        simulator.runSimulation();
    }
}