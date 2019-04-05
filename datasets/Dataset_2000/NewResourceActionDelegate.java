public class NewResourceActionDelegate extends NewResourceNodeActionDelegate
{
  public NewResourceActionDelegate()
  {
    super(Messages.getString("NewResourceAction_0"));   }
  @Override
  protected CDOResourceNode createNewResourceNode()
  {
    return EresourceFactory.eINSTANCE.createCDOResource();
  }
}