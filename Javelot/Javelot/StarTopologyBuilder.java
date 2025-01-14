import java.util.ArrayList;
import java.util.List;

public class StarTopologyBuilder implements NetworkTopologyBuilder {
    private NetworkTopology topology;

    public StarTopologyBuilder() {
        topology = new NetworkTopology();
    }

    public void addNode(Node node) {
        topology.addNode(node);
    }

    public void addLink(Link link) {
        topology.addLink(link);
    }

    public NetworkTopology build() {
        return topology;
    }
}

