@SuppressWarnings("rawtypes")
public class EclimEditorSite
  implements IEditorSite
{
  private IWorkbenchWindow window;
  private ISelectionProvider selectionProvider;
  public EclimEditorSite ()
  {
    window = new EclimWorkbenchWindow();
  }
  
  public String getId()
  {
    return StringUtils.EMPTY;
  }
  
  public String getPluginId()
  {
    return "org.eclim";
  }
  
  public String getRegisteredName()
  {
    return StringUtils.EMPTY;
  }
  
  public void registerContextMenu(
      String arg0, MenuManager arg1, ISelectionProvider arg2)
  {
  }
  
  public void registerContextMenu(MenuManager arg0, ISelectionProvider arg1)
  {
  }
  
  @SuppressWarnings("deprecation")
  public org.eclipse.ui.IKeyBindingService getKeyBindingService()
  {
    return null;
  }
  
  public IWorkbenchPart getPart()
  {
    return null;
  }
  
  public IWorkbenchPage getPage()
  {
    return window.getActivePage();
  }
  
  public ISelectionProvider getSelectionProvider()
  {
    return selectionProvider;
  }
  
  public Shell getShell()
  {
    return EclimPlugin.getShell();
  }
  
  public IWorkbenchWindow getWorkbenchWindow()
  {
    return window;
  }
  
  public void setSelectionProvider(ISelectionProvider provider)
  {
    this.selectionProvider = provider;
  }
  
  public Object getAdapter(Class arg0)
  {
    return null;
  }
  
  public Object getService(Class arg0)
  {
    return null;
  }
  
  public boolean hasService(Class arg0)
  {
    return false;
  }
  
  public IEditorActionBarContributor getActionBarContributor()
  {
    return null;
  }
  
  public IActionBars getActionBars()
  {
    return null;
  }
  
  public void registerContextMenu(
      MenuManager arg0, ISelectionProvider arg1, boolean arg2)
  {
  }
  
  public void registerContextMenu(
      String arg0, MenuManager arg1, ISelectionProvider arg2, boolean arg3)
  {
  }
}