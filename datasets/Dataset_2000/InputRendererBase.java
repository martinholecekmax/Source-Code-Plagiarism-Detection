public class InputRendererBase extends RendererBase {
    protected void doDecode(FacesContext context, UIComponent component) {
        String clientId = component.getClientId(context);
        Map<String, String> requestParameterMap = context.getExternalContext().getRequestParameterMap();
        String newValue = (String) requestParameterMap.get(clientId);
        if (null != newValue) {
            UIInput input = (UIInput) component;
            input.setSubmittedValue(newValue);
        }
    }
    public Object getConvertedValue(FacesContext context, UIComponent component, Object val) throws ConverterException {
        return InputUtils.getConvertedValue(context, component, val);
    }
    public String getInputValue(FacesContext context, UIComponent component) throws ConverterException {
        return InputUtils.getInputValue(context, component);
    }
}