public class SelectionBase extends AnnotatedBase
{
    
    public static final StringArray s_allowedAttributes = new StringArray(new String[] { "xpath" },
        AnnotatedBase.s_allowedAttributes);
            
    private String m_xpath;
    
    public SelectionBase(int type) {
        super(type);
    }
            
    protected void preset(IUnmarshallingContext ictx) throws JiBXException {
        validateAttributes(ictx, s_allowedAttributes);
        super.preset(ictx);
    }
            
    public String getXPath() {
        return m_xpath;
    }
    
    public void setXPath(String xpath) {
        m_xpath = xpath;
    }
            
    public void prevalidate(ValidationContext vctx) {
        if (getXPath() == null) {
            vctx.addError("The 'xpath' attribute is required for 'selection' and 'field' elements", this);
        }
        super.prevalidate(vctx);
    }
            public static class SelectorElement extends SelectionBase
    {
        
        public SelectorElement() {
            super(SELECTOR_TYPE);
        }
    }
    public static class FieldElement extends SelectionBase
    {
        
        public FieldElement() {
            super(FIELD_TYPE);
        }
    }
}