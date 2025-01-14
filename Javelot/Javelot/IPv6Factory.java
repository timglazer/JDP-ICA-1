public class IPv6Factory implements ProtocolFactory {
    public Protocol createNetworkProtocol() {
        return new IPv6Protocol();
    }

    public Link createLink() {
        return new WiFiLink();
    }
}
