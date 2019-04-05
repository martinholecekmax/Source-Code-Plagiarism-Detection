public abstract class AbstractVisualItemContainer implements
        VisualItemContainer {
    private transient PrioritizedHandlerManager handlerManager;
    private ErrorHandler errorHandler;
    public AbstractVisualItemContainer(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
        this.handlerManager = new PrioritizedHandlerManager(this);
    }
    @Override
    public HandlerRegistration addHandler(
            VisualItemContainerChangeEventHandler handler) {
        assert handler != null;
        return handlerManager.addHandler(VisualItemContainerChangeEvent.TYPE,
                handler);
    }
    public void fireVisualItemContainerChangeEvent(Delta<VisualItem> delta) {
        assert delta != null;
        if (delta.isEmpty()) {
            return;
        }
        try {
            handlerManager.fireEvent(new VisualItemContainerChangeEvent(this,
                    delta));
        } catch (Throwable ex) {
            errorHandler.handleError(ex);
        }
    }
}