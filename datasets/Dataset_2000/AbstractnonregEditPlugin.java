public final class AbstractnonregEditPlugin extends EMFPlugin {
	
	public static final AbstractnonregEditPlugin INSTANCE = new AbstractnonregEditPlugin();
	
	private static Implementation plugin;
	
	public AbstractnonregEditPlugin() {
		super
		  (new ResourceLocator [] {
		   });
	}
	
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
	
	public static Implementation getPlugin() {
		return plugin;
	}
	
	public static class Implementation extends EclipsePlugin {
		
		public Implementation() {
			super();
									plugin = this;
		}
	}
}