public final class QueueRequestOptions extends RequestOptions {
    
    public QueueRequestOptions() {
            }
    
    public QueueRequestOptions(final QueueRequestOptions other) {
        super(other);
    }
    
    protected void applyDefaults(final CloudQueueClient client) {
        super.applyBaseDefaults(client);
    }
}