public class NachrichtBox extends AbstractBox implements Box
{
  private final static I18N i18n = Application.getPluginLoader().getPlugin(HBCI.class).getResources().getI18N();
  
  public boolean getDefaultEnabled()
  {
    return true;
  }
  
  public int getDefaultIndex()
  {
    return 0;
  }
  
  public String getName()
  {
    return "Hibiscus: " + i18n.tr("System-Nachrichten der Bank");
  }
  
  public void paint(Composite parent) throws RemoteException
  {
    DBIterator iterator = Settings.getDBService().createList(Nachricht.class);
    iterator.setOrder("order by datum desc");     iterator.addFilter("gelesen is null or gelesen = 0");
    NachrichtList list = new NachrichtList(iterator,new NachrichtOpen());
    list.setSummary(false);
    list.paint(parent);
  }
  
  public boolean isActive()
  {
    return super.isActive() && isEnabled();   }
  
  public boolean isEnabled()
  {
    try
    {
      DBIterator iterator = Settings.getDBService().createList(Nachricht.class);
      iterator.addFilter("gelesen is null or gelesen = 0");
      return iterator.hasNext();     }
    catch (Exception e)
    {
      Logger.error("unable to check for new messages",e);
    }
    return super.isEnabled();
  }
}