public class FilteringHandler implements PacketHandler {
    private PacketHandler nextHandler;

    public void setNextHandler(PacketHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handlePacket(Packet packet) {
        // Filtering logic
        if (nextHandler != null) {
            nextHandler.handlePacket(packet);
        }
    }
}
