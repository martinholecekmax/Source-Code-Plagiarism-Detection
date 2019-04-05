public class FileSystemReportStoreTest extends ReportStoreTest {
    private File rootDir;
    @Override
    public ReportStore getReportStore() {
        rootDir = new File("reports");
        FileSystemReportStore store = new FileSystemReportStore(rootDir);        
        return store;
    }
    @Override
    public void clearStore() throws Exception {
        FileUtils.deleteDirectory(rootDir);
    }
}