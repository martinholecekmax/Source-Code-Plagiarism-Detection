public final class RmapEditPlugin extends EMFPlugin {
	
	public static class Implementation extends EclipsePlugin {
		
		public Implementation() {
			super();
									plugin = this;
		}
	}
	
	public static final RmapEditPlugin INSTANCE = new RmapEditPlugin();
	
	private static Implementation plugin;
	
	public static Implementation getPlugin() {
		return plugin;
	}
	
	public RmapEditPlugin() {
		super(new ResourceLocator[] { CommonEditPlugin.INSTANCE, });
	}
	
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
}