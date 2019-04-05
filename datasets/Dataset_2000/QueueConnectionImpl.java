public class QueueConnectionImpl extends ConnectionImpl implements QueueConnection
{
    QueueConnectionImpl(String host, int port, String username, String password, String clientId)
            throws JMSException
    {
        super(host, port, username, password, clientId);
    }
    public QueueSessionImpl createQueueSession(final boolean b, final int i) throws JMSException
    {
        return null;      }
    public ConnectionConsumer createConnectionConsumer(final Queue queue,
                                                       final String s,
                                                       final ServerSessionPool serverSessionPool,
                                                       final int i) throws JMSException
    {
        return null;      }
}