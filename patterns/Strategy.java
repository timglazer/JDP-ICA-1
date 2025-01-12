//Strategy pattern


//Apply to a variety of physical layer technologies (ethernet, WiFi, etc.)
// to make implementations more flexible.
//Refine strategies by considering transfer rates and error rates at the physical layer


// Definition of Interface
interface PhysicalLayer {
    void transmit(Packet packet);
}


interface LinkLayer {
    void frameData(Packet packet);
}


interface NetworkLayer {
    void routePacket(Packet packet);
}


// Implementations for PhysicalLayer
class EthernetPhysical implements PhysicalLayer {
    @Override
    public void transmit(Packet packet) {
        System.out.println("Transmitting over Ethernet: " + packet.getContent());
    }
}


class WiFiPhysical implements PhysicalLayer {
    @Override
    public void transmit(Packet packet) {
        System.out.println("Transmitting over WiFi: " + packet.getContent());
    }
}


// Implementations of LinkLayer
class EthernetLink implements LinkLayer {
    @Override
    public void frameData(Packet packet) {
        System.out.println("Framing data for Ethernet: " + packet.getContent());
    }
}


class WiFiLink implements LinkLayer {
    @Override
    public void frameData(Packet packet) {
        System.out.println("Framing data for WiFi: " + packet.getContent());
    }
}


// Implementation for NetworkLayer
class SimpleRouter implements NetworkLayer {
    @Override
    public void routePacket(Packet packet) {
        System.out.println("Routing packet: " + packet.getContent());
    }
}


// Device class that uses strategy interfaces
class Device {
    private PhysicalLayer physicalLayer;
    private LinkLayer linkLayer;
    private NetworkLayer networkLayer;


    public Device(PhysicalLayer physical, LinkLayer link, NetworkLayer network) {
        this.physicalLayer = physical;
        this.linkLayer = link;
        this.networkLayer = network;
    }


    public void setPhysicalLayer(PhysicalLayer physical) {
        this.physicalLayer = physical;
    }


    public void setLinkLayer(LinkLayer link) {
        this.linkLayer = link;
    }


    public void setNetworkLayer(NetworkLayer network) {
        this.networkLayer = network;
    }


    public void sendPacket(Packet packet) {
        this.networkLayer.routePacket(packet);
        this.linkLayer.frameData(packet);
        this.physicalLayer.transmit(packet);
    }
}


// Packet class
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
}


// Main class to simulate network operations
public class Strategy {
    public static void main(String[] args) {
        Packet packet = new Packet("This is a network packet");
        Device device = new Device(new EthernetPhysical(), new EthernetLink(), new SimpleRouter());


        // Sending packet with initial strategy
        device.sendPacket(packet);


        // Changing strategy to Wifi
        device.setPhysicalLayer(new WiFiPhysical());
        device.setLinkLayer(new WiFiLink());


        // Sending packet with new strategy
        device.sendPacket(packet);
    }
}
