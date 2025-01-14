public class DataCorruptionDecorator extends NetworkInterfaceDecorator {
    public DataCorruptionDecorator(NetworkInterface decoratedInterface) {
        super(decoratedInterface);
    }

    public void sendPacket(Packet packet) {
        // Add data corruption logic
        super.sendPacket(packet);
    }

    public void receivePacket(Packet packet) {
        // Add data corruption logic
        super.receivePacket(packet);
    }
}
