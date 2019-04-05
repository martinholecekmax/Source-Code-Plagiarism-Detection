@SuppressWarnings("all")
public class GraphViewStyleStandaloneSetupGenerated implements ISetup {
	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.xbase.XbaseStandaloneSetup.doSetup();
		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.graphview.style.GraphViewStyleRuntimeModule());
	}
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http:		EPackage.Registry.INSTANCE.put("http:	}
		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("gvstyle", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("gvstyle", serviceProvider);
	}
}