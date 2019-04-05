public class OpenPropertiesHandler extends AbstractProjectHandler
{
  public OpenPropertiesHandler()
  {
  }
  @Override
  protected void execute(IWorkbenchPage page, final IProject project)
  {
    PropertyDialogAction action = new PropertyDialogAction(page.getWorkbenchWindow(), new ISelectionProvider()
    {
      public ISelection getSelection()
      {
        return new StructuredSelection(project);
      }
      public void setSelection(ISelection selection)
      {
      }
      public void addSelectionChangedListener(ISelectionChangedListener listener)
      {
      }
      public void removeSelectionChangedListener(ISelectionChangedListener listener)
      {
      }
    });
    try
    {
      action.runWithEvent(null);
    }
    finally
    {
      action.dispose();
    }
  }
}