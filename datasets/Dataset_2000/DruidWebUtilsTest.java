public class DruidWebUtilsTest extends TestCase {
    public void test_getContextPath_2_5() throws Exception {
        new DruidWebUtils();         MockServletContext context = new MockServletContext() {
            public int getMajorVersion() {
                return 2;
            }
            public int getMinorVersion() {
                return 4;
            }
            public String getContextPath() {
                throw new NoSuchMethodError();
            }
        };
        Assert.assertNull(DruidWebUtils.getContextPath(context));
    }
}