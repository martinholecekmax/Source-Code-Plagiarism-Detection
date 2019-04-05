@Deprecated
public interface SessionTopicListener extends TopicListener {
    void processPreSubscriptionEvent(SessionPreSubscriptionEvent event) throws EventAbortedException;
    void processSubscriptionEvent(SessionSubscriptionEvent event) throws EventAbortedException;
    void processUnsubscriptionEvent(SessionUnsubscriptionEvent event) throws EventAbortedException;
}