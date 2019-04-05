public class CmsListDefaultAction extends CmsListDirectAction {
    
    private String m_columnForLink;
    
    private I_CmsListFormatter m_columnFormatter;
    
    public CmsListDefaultAction(String id) {
        super(id);
    }
    
    public String getColumnForLink() {
        return m_columnForLink;
    }
    
    public I_CmsListFormatter getColumnFormatter() {
        return m_columnFormatter;
    }
    
    public void setColumnForLink(CmsListColumnDefinition columnForLink) {
        m_columnForLink = columnForLink.getId();
        m_columnFormatter = columnForLink.getFormatter();
    }
    
    protected CmsHtmlIconButtonStyleEnum resolveButtonStyle() {
        if (getColumnForLink() == null) {
            return super.resolveButtonStyle();
        }
        return CmsHtmlIconButtonStyleEnum.SMALL_ICON_TEXT;
    }
    
    protected String resolveName(Locale locale) {
        if (getColumnForLink() == null) {
            return super.resolveName(locale);
        }
        Object content = (getItem().get(getColumnForLink()) != null) ? getItem().get(getColumnForLink())
        : getName().key(locale);
        if (getColumnFormatter() != null) {
            return getColumnFormatter().format(content, locale);
        }
        return content.toString();
    }
}