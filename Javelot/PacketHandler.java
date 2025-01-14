public interface PacketHandler {
    void setNextHandler(PacketHandler nextHandler);
    void handlePacket(Packet packet);
}
