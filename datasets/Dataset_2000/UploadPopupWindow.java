public class UploadPopupWindow extends PopupWindow { 
  private static final long serialVersionUID = 1L;
    protected I18nManager i18nManager;
  protected UploadComponent uploadComponent;
  public UploadPopupWindow(String caption, String description, Receiver receiver) {
    this.i18nManager = ExplorerApp.get().getI18nManager();
    init(caption, description, receiver);
    uploadComponent.addFinishedListener(new FinishedListener() {
      private static final long serialVersionUID = 1L;
      public void uploadFinished(FinishedEvent event) {
        close();
      }
    });
  }
    protected void init(String caption, String description, Receiver receiver) {
    uploadComponent = new UploadComponent(description, receiver);
    uploadComponent.setSizeFull();
    initWindow(caption);
  }
  protected void initWindow(String caption) {
        setWidth("300px");
    setHeight("300px");
    addStyleName(Reindeer.WINDOW_LIGHT);
    setModal(true);
    center();
    setCaption(caption);
    setContent(uploadComponent);
  }
    public void addFinishedListener(FinishedListener finishedListener) {
    uploadComponent.addFinishedListener(finishedListener);
  }
  public void addStartedListener(StartedListener startedListener) {
    uploadComponent.addStartedListener(startedListener);
  }
  public void addFailedListener(FailedListener failedListener) {
    uploadComponent.addFailedListener(failedListener);
  }
  public void addProgressListener(ProgressListener progressListener) {
    uploadComponent.addProgressListener(progressListener);
  }  
}