public class IPv4Factory implements ProtocolFactory {
    public Protocol createNetworkProtocol() {
        return new IPv4Protocol();
    }

    public Link createLink() {
        return new EthernetLink();
    }
}

