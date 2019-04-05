public abstract class AddressableModelCmd {
    protected DispatchAsync dispatcher;
    protected ModelNode address;
    protected BeanFactory factory;
    public AddressableModelCmd(DispatchAsync dispatcher, BeanFactory factory, ModelNode address) {
        this.dispatcher = dispatcher;
        this.factory = factory;
        this.address = address;
    }
}