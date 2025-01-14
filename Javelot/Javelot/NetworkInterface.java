public interface NetworkInterface {
    void sendPacket(Packet packet);
    void receivePacket(Packet packet);
}
