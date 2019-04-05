public class MessageSourceAccessor
{
	static
	{
		set(new ResourceBundleMessageSource());
		addBundle("messages.commonMessages");
	}
	private static MessageSource messageSource;
	
	public static MessageSource get()
	{
		if (messageSource == null)
		{
			throw new IllegalStateException(
					"Message source not set. Call set() first to set the message source.");
		}
		return messageSource;
	}
	
	public static void set(MessageSource source)
	{
		messageSource = source;
	}
	
	public static void addBundle(String baseName)
	{
		messageSource.addBundle(baseName);
	}
	
	public static String getMessage(String key)
	{
		return get().getMessage(key);
	}
	
	public static String getMessage(String key, Object... params)
	{
		return get().getMessage(key, params);
	}
	
	public static String getMessageOrDefault(String key, String defaultMsg)
	{
		return get().getMessage(key, defaultMsg);
	}
	
	public static String getMessageOrDefault(String key, String defaultMsg, Object... params)
	{
		return get().getMessage(key, defaultMsg, params);
	}
}