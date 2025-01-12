import java.util.List;
import java.util.ArrayList;


// Component Interface
interface NetworkComponent {
    void display();
}

// Leaf Component
class DeviceComponent implements NetworkComponent {
    private String name;

    public DeviceComponent(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Device: " + name);
    }
}

class MobileDevice implements NetworkComponent {
    private String name;

    public MobileDevice(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Mobile Device: " + name);
    }
}

class PrinterDevice implements NetworkComponent {
    private String name;

    public PrinterDevice(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Printer Device: " + name);
    }
}

class ServerDevice implements NetworkComponent {
    private String name;

    public ServerDevice(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Server Device: " + name);
    }
}


// Composite Component
class NetworkGroup implements NetworkComponent {
    private String groupName;
    private List<NetworkComponent> components = new ArrayList<>();

    public NetworkGroup(String groupName) {
        this.groupName = groupName;
    }

    public void add(NetworkComponent component) {
        components.add(component);
    }

    @Override
    public void display() {
        System.out.println("Group: " + groupName);
        for (NetworkComponent component : components) {
            component.display();
        }
    }
}

class CompositeDemo {
    public static void main(String[] args) {
        NetworkComponent pc1 = new DeviceComponent("PC1");
        NetworkComponent pc2 = new DeviceComponent("PC2");
        NetworkComponent mobile1 = new MobileDevice("Mobile1");
        NetworkComponent printer1 = new PrinterDevice("Printer1");
        NetworkComponent server1 = new ServerDevice("Server1");

        NetworkGroup officeNetwork = new NetworkGroup("Office Network");
        officeNetwork.add(pc1);
        officeNetwork.add(pc2);
        officeNetwork.add(mobile1);  // adding mobile device
        officeNetwork.add(printer1);
        officeNetwork.add(server1);

        officeNetwork.display();  // prints info about devices
    }
}

