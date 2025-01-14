import java.util.ArrayList;
import java.util.List;

public class Node implements Device {
    private String id;
    private List<NetworkInterface> interfaces = new ArrayList<>();

    public Node(String id) {
        this.id = id;
    }

    public void addInterface(NetworkInterface interface1) {
        interfaces.add(interface1);
    }

    public void receivePacket(Packet packet) {
        // Receive packet logic
    }

    public String getId() {
        return id;
    }
}