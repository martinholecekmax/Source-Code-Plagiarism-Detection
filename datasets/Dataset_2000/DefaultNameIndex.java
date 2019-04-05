public class DefaultNameIndex extends BasicServiceLocation implements LuceneIndex {
    private static final Logger LOGGER = Logger.getLogger(DefaultNameIndex.class);
    private Directory directory;
    private PerFieldAnalyzerWrapper analyzer;
    
    public DefaultNameIndex(String name, String path) {
        super(name, path);
                analyzer = new PerFieldAnalyzerWrapper(new ChemicalNameAnalyzer());
        analyzer.addAnalyzer(QueryService.IDENTIFIER.field(), new LowerCaseKeywordAnalyzer());
    }
    
    public DefaultNameIndex(String name, File f) {
        super(name, f);
                analyzer = new PerFieldAnalyzerWrapper(new ChemicalNameAnalyzer());
        analyzer.addAnalyzer(QueryService.IDENTIFIER.field(), new LowerCaseKeywordAnalyzer());
    }
    @Override
    public PerFieldAnalyzerWrapper getAnalyzer(){
        return analyzer;
    }
    @Override
    public Directory getDirectory() throws IOException {
        if (directory == null)
            directory = new NIOFSDirectory(getLocation());
        return directory;
    }
}