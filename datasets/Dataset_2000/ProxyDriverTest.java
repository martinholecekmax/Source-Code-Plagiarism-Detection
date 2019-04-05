public class ProxyDriverTest extends TestCase {
    public void test_connect() throws Exception {
        String url = "jdbc:wrap-jdbc:filters=default:name=clobTest:jdbc:derby:memory:clobTestDB;create=true";
        Connection conn = DriverManager.getConnection(url);
        conn.close();
    }
}