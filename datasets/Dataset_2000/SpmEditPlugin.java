public final class SpmEditPlugin extends EMFPlugin {
	
	public static final SpmEditPlugin INSTANCE = new SpmEditPlugin();
	
	private static Implementation plugin;
	
	public SpmEditPlugin() {
		super
		  (new ResourceLocator [] {
		     SmmEditPlugin.INSTANCE,
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