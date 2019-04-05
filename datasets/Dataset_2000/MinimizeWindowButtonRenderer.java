public class MinimizeWindowButtonRenderer extends ToggleCaptionButtonRenderer {
    @Override
    protected void checkContainerType(ComponentWithCaption container) {
        if (!(container instanceof AbstractWindow))
            throw new FacesException("<o:minimizeWindowButton> can only be used in <o:window> and <o:confirmation> components.");
    }
    @Override
    protected String getDefaultImageUrl(FacesContext context) {
        return Resources.internalURL(context, "window/minimize.gif");
    }
    @Override
    protected String getDefaultToggleImageUrl(FacesContext context) {
        return Resources.internalURL(context, "window/restore.gif");
    }
    @Override
    protected String getInitFunctionName() {
        return "O$.Window._initMinimizeButton";
    }
    @Override
    protected List<String> getJsLibraries(FacesContext context) {
        List<String> libraries = super.getJsLibraries(context);
        libraries.add(AbstractWindowRenderer.getWindowJs(context));
        return libraries;
    }
}