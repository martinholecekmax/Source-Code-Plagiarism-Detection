class MicroscopeHandler implements ModelObjectHandler
{
	
	private EnumerationProvider enumProvider;
	
	static final Class<? extends IObject> HANDLER_FOR = Microscope.class;
	
	MicroscopeHandler(EnumerationProvider enumProvider)
	{
		this.enumProvider = enumProvider;
	}
	
	public IObject handle(IObject object)
	{
		Microscope o = (Microscope) object;
		o.setType(enumProvider.getEnumeration(
		        MicroscopeType.class, "Unknown", false));
		return object;
	}
}