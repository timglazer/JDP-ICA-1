public class Packet {
    private String source;
    private String destination;
    private String payload;

    public Packet(String source, String destination, String payload) {
        this.source = source;
        this.destination = destination;
        this.payload = payload;
    }

    // Getter for source
    public String getSource() {
        return source;
    }

    // Getter for destination
    public String getDestination() {
        return destination;
    }

    // Getter for payload
    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}