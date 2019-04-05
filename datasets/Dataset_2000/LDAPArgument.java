public class LDAPArgument extends AbstractTestElement implements Serializable {
    private static final long serialVersionUID = 240L;
        
    private static final String ARG_NAME = "Argument.name";     
    private static final String VALUE = "Argument.value";     
    private static final String OPCODE = "Argument.opcode";     
    private static final String METADATA = "Argument.metadata";     
    public LDAPArgument() {
    }
    
    public LDAPArgument(String name, String value, String opcode) {
        setProperty(new StringProperty(ARG_NAME, name));
        setProperty(new StringProperty(VALUE, value));
        setProperty(new StringProperty(OPCODE, opcode));
    }
    
    public LDAPArgument(String name, String value, String opcode, String metadata) {
        setProperty(new StringProperty(ARG_NAME, name));
        setProperty(new StringProperty(VALUE, value));
        setProperty(new StringProperty(OPCODE, opcode));
        setProperty(new StringProperty(METADATA, metadata));
    }
    
    @Override
    public void setName(String newName) {
        setProperty(new StringProperty(ARG_NAME, newName));
    }
    
    @Override
    public String getName() {
        return getPropertyAsString(ARG_NAME);
    }
    
    public void setValue(String newValue) {
        setProperty(new StringProperty(VALUE, newValue));
    }
    
    public String getValue() {
        return getPropertyAsString(VALUE);
    }
    
    public void setOpcode(String newOpcode) {
        setProperty(new StringProperty(OPCODE, newOpcode));
    }
    
    public String getOpcode() {
        return getPropertyAsString(OPCODE);
    }
    
    public void setMetaData(String newMetaData) {
        setProperty(new StringProperty(METADATA, newMetaData));
    }
    
    public String getMetaData() {
        return getPropertyAsString(METADATA);
    }
}