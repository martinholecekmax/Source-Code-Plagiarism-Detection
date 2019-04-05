@Singleton
public class AppendApiVersionToAbiquoMimeType implements Function<String, String>
{
    
    private static final String ABIQUO_MIME_TYPE_PREFIX = "application/vnd.abiquo.";
    
    protected String apiVersion;
    @Inject
    public AppendApiVersionToAbiquoMimeType(@ApiVersion final String apiVersion)
    {
        super();
        this.apiVersion = checkNotNull(apiVersion, "apiVersion");
    }
    @Override
    public String apply(final String input)
    {
        MediaType mediaType = MediaType.valueOf(checkNotNull(input, "input"));
        if (isAbiquoMimeType(input) && !mediaType.getParameters().containsKey("version"))
        {
            return mediaType.toString() + ";version=" + apiVersion;
        }
        else
        {
            return mediaType.toString();
        }
    }
    private static boolean isAbiquoMimeType(final String mimeType)
    {
        return mimeType.startsWith(ABIQUO_MIME_TYPE_PREFIX);
    }
}