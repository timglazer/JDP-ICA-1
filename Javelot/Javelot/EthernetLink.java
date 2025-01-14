public class EthernetLink implements Link, NetworkInterface {
    public void transmitPacket(Packet packet) {
        // Transmitting packet over Ethernet
    }

    @Override
    public void sendPacket(Packet packet) {
        System.out.println("Packet sent via Ethernet: " + packet);
    }

    @Override
    public void receivePacket(Packet packet) {
        System.out.println("Packet received via Ethernet: " + packet);
    }
}
