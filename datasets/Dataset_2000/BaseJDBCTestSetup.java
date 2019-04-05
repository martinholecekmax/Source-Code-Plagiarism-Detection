public abstract class BaseJDBCTestSetup
    extends BaseTestSetup {
	public BaseJDBCTestSetup(Test test) {
		super(test);
	}
	
	private Connection conn;
    
    public final TestConfiguration getTestConfiguration()
    {
    	return TestConfiguration.getCurrent();
    }
    
    public final Connection getConnection() throws SQLException
    {
    	if (conn != null)
    	{
    		if (!conn.isClosed())
    			return conn;
    		conn = null;
    	}
    	return conn = getTestConfiguration().openDefaultConnection();
    }
    
    public void println(final String text) {
        if (getTestConfiguration().isVerbose()) {
            System.out.println("DEBUG: " + text);
        }
    }
    
    protected void tearDown()
    throws java.lang.Exception
    {
        clearConnection();
    }
    
    void clearConnection() throws SQLException {
        JDBC.cleanup(conn);
        conn = null;
    }
}