public class PluginsAddedEvent extends PluginsListEvent {
	public PluginsAddedEvent(final PluginInfo<?> o) {
		super(o);
	}
	public PluginsAddedEvent(final Collection<? extends PluginInfo<?>> c) {
		super(c);
	}
}