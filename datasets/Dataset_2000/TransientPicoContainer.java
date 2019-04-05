@SuppressWarnings("serial")
public class TransientPicoContainer extends DefaultPicoContainer {
    public TransientPicoContainer() {
        super(null, new NullLifecycleStrategy(), new NullComponentMonitor(), new Caching().wrap(new ConstructorInjection()));
    }
    public TransientPicoContainer(PicoContainer parent) {
        super(parent, new NullLifecycleStrategy(), new NullComponentMonitor(), new Caching().wrap(new ConstructorInjection()));
    }
    public TransientPicoContainer(ComponentFactory componentFactory, PicoContainer parent) {
        super(parent, new NullLifecycleStrategy(), new NullComponentMonitor(), componentFactory);
    }
}