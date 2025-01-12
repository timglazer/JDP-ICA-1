//Decorator pattern


//Apply decorator patterns to add different dynamic features to packets
//This pattern helps you expand the behavior of an object during execution
// without adding responsibility to the default object.


// Base Component
class Packet {
    private String content;


    public Packet(String content) {
        this.content = content;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public void transmit() {
        System.out.println("Transmitting packet: " + getContent());
    }
}


// Abstract Decorator
abstract class PacketDecorator extends Packet {
    protected Packet packet;


    public PacketDecorator(Packet packet) {
        super(packet.getContent());
        this.packet = packet;
    }


    @Override
    public abstract void transmit();
}


// Concrete Decorator for Adding Delay
class DelayDecorator extends PacketDecorator {
    private int delayMilliseconds;


    public DelayDecorator(Packet packet, int delayMilliseconds) {
        super(packet);
        this.delayMilliseconds = delayMilliseconds;
    }


    @Override
    public void transmit() {
        try {
            Thread.sleep(delayMilliseconds); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Transmitting with delay of " + delayMilliseconds + " ms.");
        packet.transmit();
    }
}


// Concrete Decorator for Simulating Corruption
class CorruptionDecorator extends PacketDecorator {
    private double corruptionChance; // Chance of corruption


    public CorruptionDecorator(Packet packet, double corruptionChance) {
        super(packet);
        this.corruptionChance = corruptionChance;
    }


    @Override
    public void transmit() {
        // Simulate a chance of corruption
        if (Math.random() < corruptionChance) {
            System.out.println("Packet corrupted!");
        } else {
            packet.transmit();
        }
    }
}


// Main class to demonstrate the use of decorators
public class Decorator {
    public static void main(String[] args) {
        Packet packet = new Packet("This is a network packet");
        Packet delayedPacket = new DelayDecorator(packet, 500); // Adding 500 ms delay
        Packet corruptedAndDelayedPacket = new CorruptionDecorator(delayedPacket, 0.3); // Adding corruption with 30% probability


        // Transmitting the packet with added behaviors
        corruptedAndDelayedPacket.transmit();
    }
}
