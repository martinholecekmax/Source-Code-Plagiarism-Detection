final public class ExtensionEventDispatcherJob extends Job {
		private final static ISchedulingRule EXTENSION_EVENT_RULE = new ISchedulingRule() {
		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}
		public boolean isConflicting(ISchedulingRule rule) {
			return rule == this;
		}
	};
	private Map deltas;
	private Object[] listenerInfos;
	private Object registry;
	public ExtensionEventDispatcherJob(Object[] listenerInfos, Map deltas, Object registry) {
				super("Registry event dispatcher"); 		setSystem(true);
		this.listenerInfos = listenerInfos;
		this.deltas = deltas;
		this.registry = registry;
				setRule(EXTENSION_EVENT_RULE);
	}
	public IStatus run(IProgressMonitor monitor) {
		return RegistryStrategy.processChangeEvent(listenerInfos, deltas, registry);
	}
}