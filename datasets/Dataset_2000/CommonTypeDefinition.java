public abstract class CommonTypeDefinition extends AnnotatedBase implements INamed
{
    
    public static final StringArray s_allowedAttributes =
        new StringArray(new String[] { "name" },
        AnnotatedBase.s_allowedAttributes);
    
    private String m_name;
    
    protected QName m_qname;
    
    public CommonTypeDefinition(int type) {
        super(type);
    }
    
    public abstract boolean isComplexType();
    
    public abstract boolean isPredefinedType();
    
    public String getName() {
        return m_name;
    }
    
    public void setName(String name) {
        m_name = name;
    }
    
    public QName getQName() {
        return m_qname;
    }
            
    public void prevalidate(ValidationContext vctx) {
                if (isGlobal()) {
                        if (getName() == null) {
                vctx.addError("The 'name' attribute is required for a global definition", this);
            } else {
                String ens = vctx.getCurrentSchema().getEffectiveNamespace();
                m_qname = new QName(ens, getName());
            }
        } else {
                        if (getName() != null) {
                vctx.addError("The 'name' attribute is prohibited for a local definition", this);
            }
        }
                super.prevalidate(vctx);
    }
}