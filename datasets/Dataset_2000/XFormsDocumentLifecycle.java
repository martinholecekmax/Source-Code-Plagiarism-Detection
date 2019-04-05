public interface XFormsDocumentLifecycle {
    void afterInitialResponse();
    void beforeExternalEvents(ExternalContext.Response response);
    void afterExternalEvents();
    void afterUpdateResponse();
}