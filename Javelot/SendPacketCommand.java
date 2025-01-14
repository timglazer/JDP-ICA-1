public class SendPacketCommand implements TrafficCommand {
    private Packet packet;
    private NetworkInterface source;

    public SendPacketCommand(Packet packet, NetworkInterface source) {
        this.packet = packet;
        this.source = source;
    }

    public void execute() {
        System.out.println("Executing SendPacketCommand: Sending packet from " + packet.getSource() + " to " + packet.getDestination());
        source.sendPacket(packet);
    }
}