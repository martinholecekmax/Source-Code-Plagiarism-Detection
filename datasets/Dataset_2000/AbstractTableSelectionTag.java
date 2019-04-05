public abstract class AbstractTableSelectionTag extends OUICommandTag {
    @Override
    public void setComponentProperties(FacesContext facesContext, UIComponent component) {
        super.setComponentProperties(facesContext, component);
        setStringProperty(component, "rawStyleClass");
        setBooleanProperty(component, "enabled");
        setBooleanProperty(component, "required");
        setBooleanProperty(component, "mouseSupport");
        setBooleanProperty(component, "keyboardSupport");
        setStringProperty(component, "onchange");
    }
}