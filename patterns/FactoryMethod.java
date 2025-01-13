// Abstract Device
abstract class Device {
    protected PhysicalLayer physicalLayer;
    protected LinkLayer linkLayer;
    protected Router router;

    public Device(PhysicalLayer physicalLayer, LinkLayer linkLayer, Router router) {
        this.physicalLayer = physicalLayer;
        this.linkLayer = linkLayer;
        this.router = router;
    }

    public void sendPacket(Packet packet) {
        physicalLayer.send(packet);
        linkLayer.send(packet);
        router.route(packet);
    }
}

// Physical Layer
interface PhysicalLayer {
    void send(Packet packet);
}

// Link Layer
interface LinkLayer {
    void send(Packet packet);
}

// Router
interface Router {
    void route(Packet packet);
}

// WiFi Physical Layer
class WiFiPhysical implements PhysicalLayer {
    @Override
    public void send(Packet packet) {
        System.out.println("Packet passed through WiFi physical layer: " + packet.getContent());
    }
}

// Ethernet Physical Layer
class EthernetPhysical implements PhysicalLayer {
    @Override
    public void send(Packet packet) {
        System.out.println("Packet passed through Ethernet physical layer: " + packet.getContent());
    }
}

// WiFi Link Layer
class WiFiLink implements LinkLayer {
    @Override
    public void send(Packet packet) {
        System.out.println("Packet passed through WiFi link layer: " + packet.getContent());
    }
}

// Ethernet Link Layer
class EthernetLink implements LinkLayer {
    @Override
    public void send(Packet packet) {
        System.out.println("Packet passed through Ethernet link layer: " + packet.getContent());
    }
}

// Simple Router
class SimpleRouter implements Router {
    @Override
    public void route(Packet packet) {
        System.out.println("Packet routed by simple router: " + packet.getContent());
    }
}


// Packet
class Packet {
    private String content;

    public Packet(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Abstract Factory
abstract class DeviceFactory {
    public abstract Device createDevice(String name);
}

// WiFi Device Factory
class WiFiDeviceFactory extends DeviceFactory {
    @Override
    public Device createDevice(String name) {
        return new Device(new WiFiPhysical(), new WiFiLink(), new SimpleRouter()) {};
    }
}

// Ethernet Device Factory
class EthernetDeviceFactory extends DeviceFactory {
    @Override
    public Device createDevice(String name) {
        return new Device(new EthernetPhysical(), new EthernetLink(), new SimpleRouter()) {};
    }
}

// Demonstration
public class FactoryMethod {
    public static void main(String[] args) {
        DeviceFactory wifiFactory = new WiFiDeviceFactory();
        DeviceFactory ethernetFactory = new EthernetDeviceFactory();

        Device wifiDevice = wifiFactory.createDevice("WiFi Device");
        Device ethernetDevice = ethernetFactory.createDevice("Ethernet Device");

        Packet packet = new Packet("Factory Packet");
        wifiDevice.sendPacket(packet);
        ethernetDevice.sendPacket(packet);
    }
}
