public class SVNModule implements Module {
	@Override
	public void configure(Binder binder) {
		Multibinder<SCMConnector> uriBinder = Multibinder.newSetBinder(binder,
				SCMConnector.class);
		uriBinder.addBinding().to(SVNConnector.class);
		uriBinder.addBinding().to(ESVNConnector.class);
	}
}