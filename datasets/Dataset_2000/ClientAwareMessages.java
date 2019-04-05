@Named("clientMessages")
@Singleton
public class ClientAwareMessages extends MapHelper<String, String>
{
    @Inject
    @ClientQualifier
    private MessageContext clientAwareMessageContext;
    protected String getValue(String key)
    {
        return this.clientAwareMessageContext.message().text(key).toText();
    }
}