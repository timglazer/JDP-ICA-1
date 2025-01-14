import java.util.ArrayList;
import java.util.List;

public class NetworkTopology {
    private List<Node> nodes = new ArrayList<>();
    private List<Link> links = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addLink(Link link) {
        links.add(link);
    }
}
