public class SimpleRedirectActionHandler extends BaseRedirectActionHandler {
	public static String getHandlerType() {
		return SimpleRedirectActionHandler.class.getName();
	}
	public Collection<String> getPropertyNames() {
		return _propertyNames;
	}
	public String getType() {
		return getHandlerType();
	}
	@Override
	protected String getURL(
		MDRAction mdrAction, HttpServletRequest request,
		HttpServletResponse response) {
		UnicodeProperties typeSettingsProperties =
			mdrAction.getTypeSettingsProperties();
		return GetterUtil.getString(typeSettingsProperties.getProperty("url"));
	}
	private static Collection<String> _propertyNames;
	static {
		_propertyNames = new ArrayList<String>(1);
		_propertyNames.add("url");
		_propertyNames = Collections.unmodifiableCollection(_propertyNames);
	}
}