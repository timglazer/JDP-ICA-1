public class RoutingHandler implements PacketHandler {
    private PacketHandler nextHandler;

    public void setNextHandler(PacketHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handlePacket(Packet packet) {
        // Routing logic
        if (nextHandler != null) {
            nextHandler.handlePacket(packet);
        }
    }
}

