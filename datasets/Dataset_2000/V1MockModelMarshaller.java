public class V1MockModelMarshaller extends BaseMarshaller {
    
    public V1MockModelMarshaller(final Descriptor desc) {
        super(desc);
    }
    @Override
    public Model read(final Configuration config) {
        Model model = null;
        if (config.getName().startsWith(BindingModel.BINDING)) {
            model = new V1MockBindingModel(config, getDescriptor());
        } else if (config.getName().startsWith(ComponentImplementationModel.IMPLEMENTATION)) {
            model = new V1MockImplementationModel(config, getDescriptor());
        }
        return model;
    }
}