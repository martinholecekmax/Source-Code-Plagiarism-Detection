public class LocalClientMessageProcessorBuilder extends AbstractOutboundMessageProcessorBuilder
{
    @Override
    protected void configureMessageProcessor(CxfOutboundMessageProcessor processor)
    {
    }
    @Override
    protected Client createClient() throws CreateException, Exception
    {
        String uri = getAddress();
        int idx = uri.indexOf('?');
        if (idx != -1)
        {
            uri = uri.substring(0, idx);
        }
                idx = uri.indexOf('@');
        int slashIdx = uri.indexOf("        if (idx != -1 && slashIdx != -1)
        {
            uri = uri.substring(0, slashIdx + 2) + uri.substring(idx + 1);
        }
        EndpointInfo ei = new EndpointInfo();
        ei.setAddress(uri);
        DestinationFactoryManager dfm = getBus().getExtension(DestinationFactoryManager.class);
        DestinationFactory df = dfm.getDestinationFactoryForUri(uri);
        if (df == null)
        {
            throw new Exception("Could not find a destination factory for uri " + uri);
        }
        Destination dest = df.getDestination(ei);
        MessageObserver mo = dest.getMessageObserver();
        if (mo instanceof ChainInitiationObserver)
        {
            ChainInitiationObserver cMo = (ChainInitiationObserver) mo;
            Endpoint cxfEP = cMo.getEndpoint();
            return new ClientImpl(getBus(), cxfEP);
        }
        else
        {
            throw new Exception("Could not create client! No Server was found directly on the endpoint: "
                                + uri);
        }
    }
}