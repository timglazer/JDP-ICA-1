// Decorator Pattern Implementation for Network Interface

// Base Interface
interface NetworkInterface {
    void sendPacket(Packet packet);
    void receivePacket(Packet packet);
}

// Concrete Implementation of Network Interface
class BasicNetworkInterface implements NetworkInterface {
    @Override
    public void sendPacket(Packet packet) {
        System.out.println("Sending packet: " + packet.getContent());
    }

    @Override
    public void receivePacket(Packet packet) {
        System.out.println("Receiving packet: " + packet.getContent());
    }
}

// Abstract Decorator
abstract class NetworkInterfaceDecorator implements NetworkInterface {
    protected NetworkInterface decoratedInterface;

    public NetworkInterfaceDecorator(NetworkInterface decoratedInterface) {
        this.decoratedInterface = decoratedInterface;
    }

    @Override
    public void sendPacket(Packet packet) {
        decoratedInterface.sendPacket(packet);
    }

    @Override
    public void receivePacket(Packet packet) {
        decoratedInterface.receivePacket(packet);
    }
}

// Concrete Decorator for Data Corruption Simulation
class DataCorruptionDecorator extends NetworkInterfaceDecorator {
    public DataCorruptionDecorator(NetworkInterface decoratedInterface) {
        super(decoratedInterface);
    }

    @Override
    public void sendPacket(Packet packet) {
        if (Math.random() < 0.2) { // Simulate 20% chance of corruption
            System.out.println("Packet corrupted during sending!");
        } else {
            super.sendPacket(packet);
        }
    }

    @Override
    public void receivePacket(Packet packet) {
        if (Math.random() < 0.2) { // Simulate 20% chance of corruption
            System.out.println("Packet corrupted during receiving!");
        } else {
            super.receivePacket(packet);
        }
    }
}


// Main Class to Demonstrate the Pattern
public class Decorator {
    public static void main(String[] args) {
        NetworkInterface basicInterface = new BasicNetworkInterface();
        NetworkInterface corruptedInterface = new DataCorruptionDecorator(basicInterface);

        Packet packet = new Packet("This is a network packet.");

        System.out.println("--- Sending Packet ---");
        corruptedInterface.sendPacket(packet);

        System.out.println("--- Receiving Packet ---");
        corruptedInterface.receivePacket(packet);
    }
}

