public class ChangePassiveUpdateAction extends EditingDomainAction
{
  public static final String ID = "change-passiveupdate";   private static final String TITLE = Messages.getString("ChangePassiveUpdateAction.1");   private CDOSession session;
  private IListener passiveUpdateListener = new IListener()
  {
    public void notifyEvent(IEvent event)
    {
      if (session != null)
      {
        if (event instanceof CDOSession.Options.PassiveUpdateEvent)
        {
          setChecked(session.options().isPassiveUpdateEnabled());
        }
      }
    }
  };
  public ChangePassiveUpdateAction()
  {
    super(TITLE);
    setId(ID);
  }
  @Override
  protected void doRun(IProgressMonitor progressMonitor) throws Exception
  {
    if (session != null)
    {
      session.options().setPassiveUpdateEnabled(!session.options().isPassiveUpdateEnabled());
    }
    update();
  }
  @Override
  public void update()
  {
    super.update();
    setChecked(session != null ? session.options().isPassiveUpdateEnabled() : false);
  }
  
  public void setSession(CDOSession session)
  {
    if (this.session != null)
    {
      session.options().removeListener(passiveUpdateListener);
    }
    this.session = session;
    if (this.session != null)
    {
      session.options().addListener(passiveUpdateListener);
    }
  }
}