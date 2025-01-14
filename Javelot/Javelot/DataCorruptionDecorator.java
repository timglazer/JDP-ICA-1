public class DataCorruptionDecorator extends NetworkInterfaceDecorator {
    public DataCorruptionDecorator(NetworkInterface decoratedInterface) {
        super(decoratedInterface);
    }

    public void sendPacket(Packet packet) {
        // Data corruption logic
        super.sendPacket(packet);
    }

    public void receivePacket(Packet packet) {
        // Data corruption logic
        super.receivePacket(packet);
    }
}
