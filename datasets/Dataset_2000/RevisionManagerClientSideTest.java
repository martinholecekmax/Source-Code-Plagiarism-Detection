public class RevisionManagerClientSideTest extends RevisionManagerTest
{
  @Override
  protected InternalCDORevisionManager getRevisionManager(InternalRepository repository, InternalCDOSession session)
  {
    return session.getRevisionManager();
  }
  @Override
  protected String getLocation()
  {
    return "Client";
  }
  @Override
  protected void dumpCache(CDOBranchPoint branchPoint)
  {
    BranchingTest.dump("ServerCache", repository.getRevisionManager().getCache().getAllRevisions());
    super.dumpCache(branchPoint);
  }
}