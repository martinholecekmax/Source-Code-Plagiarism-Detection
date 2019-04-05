public class BootstrappingDependencyEvent extends OsgiBundleApplicationContextEvent {
	private final OsgiServiceDependencyEvent dependencyEvent;
	
	public BootstrappingDependencyEvent(ApplicationContext source, Bundle bundle, OsgiServiceDependencyEvent nestedEvent) {
		super(source, bundle);
		Assert.notNull(nestedEvent);
		this.dependencyEvent = nestedEvent;
	}
	
	public OsgiServiceDependencyEvent getDependencyEvent() {
		return dependencyEvent;
	}
}