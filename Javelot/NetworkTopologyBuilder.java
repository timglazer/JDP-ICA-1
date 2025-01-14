public interface NetworkTopologyBuilder {
    void addNode(Node node);
    void addLink(Link link);
    NetworkTopology build();
}
