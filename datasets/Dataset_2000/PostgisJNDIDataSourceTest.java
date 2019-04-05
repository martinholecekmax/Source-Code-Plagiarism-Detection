public  class PostgisJNDIDataSourceTest extends JDBCJNDIDataSourceTest {
    protected JDBCJNDITestSetup createTestSetup() {
        return new JDBCJNDITestSetup(new PostGISTestSetup());
    }
    @Override
    protected JDBCJNDIDataStoreFactory getJNDIStoreFactory() {
        return new PostgisNGJNDIDataStoreFactory();
    }
    @Override
    protected JDBCDataStoreFactory getDataStoreFactory() {
        return new PostgisNGDataStoreFactory();
    }
}