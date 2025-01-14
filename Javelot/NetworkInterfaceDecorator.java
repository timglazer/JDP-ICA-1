public abstract class NetworkInterfaceDecorator implements NetworkInterface {
    protected NetworkInterface decoratedInterface;

    public NetworkInterfaceDecorator(NetworkInterface decoratedInterface) {
        this.decoratedInterface = decoratedInterface;
    }

    public void sendPacket(Packet packet) {
        decoratedInterface.sendPacket(packet);
    }

    public void receivePacket(Packet packet) {
        decoratedInterface.receivePacket(packet);
    }
}

