public interface SqlMapClient extends SqlMapExecutor, SqlMapTransactionManager {
  
  public SqlMapSession openSession();
  
  public SqlMapSession openSession(Connection conn);
  
  public void flushDataCache();
  
  public void flushDataCache(String cacheId);
  
  }