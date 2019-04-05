public class JLabelImplClass extends AbstractSwingImplClass 
    implements IJLabelImplClass {
    
    private JLabel m_label;
    
    public void setComponent(Object graphicsComponent) {
        m_label = (JLabel)graphicsComponent;
    }
    
    public JComponent getComponent() {
        return m_label;
    }
    
    public void gdVerifyText(String text, String operator) {
        String actual = (String)getEventThreadQueuer().invokeAndWait(
            "getText", new IRunnable() {                 public Object run() {
                    return m_label.getText();
                }
            });
        Verifier.match(actual, text, operator);
    }
    
    public void gdVerifyText(String text) {
        gdVerifyText(text, MatchUtil.DEFAULT_OPERATOR);
    }
    
    public String gdReadValue(String variable) {
        return getText();
    }
    
    public String[] getTextArrayFromComponent() {
        return new String[] {getText()};
    }
    
    protected String getText() {
        return m_label.getText();
    }
}