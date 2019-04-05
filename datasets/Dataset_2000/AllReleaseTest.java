public class AllReleaseTest extends TestCase {
    private SegmentationServerTestMock segmentationServerTestMock;
    private Directory directory;
    public void test_executeAllTestRelease() throws Exception {
        ReleaseTestRunner.main(new String[]{directory.getAbsolutePath() + "\\src\\main"});
    }
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        directory = PathUtil.findBaseDirectory(getClass());
        segmentationServerTestMock = new SegmentationServerTestMock(new String[]{"-configuration "
                                                                                 + directory.getAbsolutePath()
                                                                                 + "/target/test-classes/server-config.properties"});
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        segmentationServerTestMock.stop();
    }
}