public class DefaultReplayStrategy implements ReplayStrategy {
    private int maximumDifference = 5;
    public DefaultReplayStrategy() {
    }
    public DefaultReplayStrategy(int maximumDifference) {
        this.maximumDifference = maximumDifference;
    }
    public boolean onDroppedPackets(ReliableTransport transport, int expectedCounter, int actualCounter, int nextAvailableCounter) throws IOException {
        int difference = actualCounter - expectedCounter;
        long count = Math.abs(difference);
        if (count > maximumDifference) {
            int upperLimit = actualCounter - 1;
            if (upperLimit < expectedCounter) {
                upperLimit = expectedCounter;
            }
            transport.requestReplay(expectedCounter, upperLimit);
        }
                return difference > 0;
    }
    public void onReceivedPacket(ReliableTransport transport, long expectedCounter) {
            }
    public int getMaximumDifference() {
        return maximumDifference;
    }
    
    public void setMaximumDifference(int maximumDifference) {
        this.maximumDifference = maximumDifference;
    }
}