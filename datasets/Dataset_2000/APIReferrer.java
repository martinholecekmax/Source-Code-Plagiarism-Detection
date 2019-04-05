@SuppressWarnings("unused")
public abstract class APIReferrer extends AtomicReference<Device> implements   EventAdmin {
		private static final long	serialVersionUID	= 1L;
	static Configuration config;
	public static HttpService publicReference() { return null; }			protected static Wire protectedReference() { return null; }        	private static Configuration privateReference() { return null; }
	static Configuration packagePrivateReference() { return null; }
    public static void publicReference( org.osgi.service.component.ComponentConstants ad) {}     protected static void protectedReference( BeanArgument ad) {}      static void packagePrivateReference( Configuration ad) {}
    private static void privateReference( Configuration ad) {}
    public static void publicFoo( Class<org.osgi.service.condpermadmin.BundleLocationCondition> foo) {}     protected static void protectedFoo( Class<LogService> foo) {} 	private static void privateFoo( Class<Configuration> foo) {}
	static void packagePrivateFoo( Class<Configuration> foo) {}
    public static void foo() {
    	Configuration foo;
    }
    private static void foop() {
    	Configuration foo;
    }
}