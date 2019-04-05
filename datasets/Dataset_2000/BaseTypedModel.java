public abstract class BaseTypedModel extends BaseModel implements TypedModel {
    protected BaseTypedModel(QName qname) {
        super(qname);
    }
    protected BaseTypedModel(Configuration config) {
        super(config);
    }
    protected BaseTypedModel(Configuration config, Descriptor desc) {
        super(config, desc);
    }
    
    @Override
    public final String getType() {
        String name = getModelConfiguration().getName();
        if (name != null) {
            int pos = name.indexOf('.');
            if (pos > -1) {
                return name.substring(pos+1, name.length());
            }
        }
        return null;
    }
}