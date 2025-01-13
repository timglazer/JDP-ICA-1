

// Router
interface Router {
    void route(Packet packet);
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
