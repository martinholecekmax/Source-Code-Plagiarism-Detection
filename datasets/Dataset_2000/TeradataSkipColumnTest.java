public class TeradataSkipColumnTest extends JDBCSkipColumnTest {
    protected JDBCSkipColumnTestSetup createTestSetup() {
        return new TeradataSkipColumnTestSetup(new TeradataTestSetup());
    }
}