public class CDORevisionLazyInitializer extends AbstractLazyInitializer implements Serializable
{
  private static final long serialVersionUID = 1L;
  CDORevisionLazyInitializer(String entityName, Serializable id, SessionImplementor session)
  {
    super(entityName, id, session);
  }
  public InternalCDORevision getRevision()
  {
    return (InternalCDORevision)getImplementation();
  }
  @SuppressWarnings("rawtypes")
  public Class getPersistentClass()
  {
    throw new UnsupportedOperationException();
  }
}