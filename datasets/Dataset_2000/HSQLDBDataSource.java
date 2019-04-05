public class HSQLDBDataSource extends JDBCDataSource
{
  private static final long serialVersionUID = 1L;
  public HSQLDBDataSource()
  {
  }
  @Override
  public String toString()
  {
    return MessageFormat.format("HSQLDBDataSource[database={0}, user={1}]", getDatabase(), getUser());   }
}