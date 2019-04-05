@Deprecated
public class ForwardingConsumer extends MessageFilter
{
    @Override
    public MuleEvent processNext(MuleEvent event) throws MessagingException
    {
        if (!(event.getFlowConstruct() instanceof Service))
        {
            throw new UnsupportedOperationException("ForwardingConsumer is only supported with Service");
        }
        MessageProcessor processor = ((Service) event.getFlowConstruct()).getOutboundMessageProcessor();
                        event.setStopFurtherProcessing(true);
        if (processor == null)
        {
            logger.debug("Descriptor has no outbound router configured to forward to, continuing with normal processing");
            return event;
        }
        else
        {
            try
            {
                MuleEvent resultEvent = processor.process(event);
                if (resultEvent != null && !VoidMuleEvent.getInstance().equals(resultEvent))
                {
                    return resultEvent;
                }
                else
                {
                    return null;
                }
            }
            catch (MuleException e)
            {
                throw new RoutingException(event, this, e);
            }
        }
    }
}