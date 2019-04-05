public class TimingMsg implements Serializable {
    private static final long serialVersionUID = 1L;
    public long               interval;
    public long               timeout;
    public TimingMsg(long interval, long timeout) {
        this.interval = interval;
        this.timeout = timeout;
    }
}