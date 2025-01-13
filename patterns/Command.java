// Command Pattern Implementation

// Command Interface
interface TrafficCommand {
    void execute();
}

// Supporting Classes for Nodes and Packets
class Node {
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Concrete Command: SendPacketCommand
class SendPacketCommand implements TrafficCommand {
    private Node source;
    private Node destination;
    private Packet packet;

    public SendPacketCommand(Node source, Node destination, Packet packet) {
        this.source = source;
        this.destination = destination;
        this.packet = packet;
    }

    @Override
    public void execute() {
        System.out.println("Sending packet from " + source.getName() +
                " to " + destination.getName() + ": " +
                packet.getContent());
    }
}

// Main Class to Demonstrate the Command Pattern
public class Command {
    public static void main(String[] args) {
        // Create Nodes
        Node sourceNode = new Node("SourceNode");
        Node destinationNode = new Node("DestinationNode");

        // Create Packet
        Packet packet = new Packet("Important Data");

        // Create Command
        TrafficCommand sendPacketCommand = new SendPacketCommand(sourceNode, destinationNode, packet);

        // Execute Command
        sendPacketCommand.execute();
    }
}
