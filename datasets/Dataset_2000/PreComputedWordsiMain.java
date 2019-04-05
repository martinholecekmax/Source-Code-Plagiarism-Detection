public class PreComputedWordsiMain extends GenericWordsiMain {
    
    private BasisMapping<String, String> basis;
    
    protected void handleExtraOptions() {
                if (argOptions.hasOption('L'))
            basis = loadObject(openLoadFile());
        else 
            basis = new StringBasisMapping();
    }
    
    protected void postProcessing() {
        if (argOptions.hasOption('S'))
            saveObject(openSaveFile(), basis);
    }
    
    protected ContextExtractor getExtractor() {
        return new PreComputedContextExtractor(basis);
    }
    
    protected SSpaceFormat getSpaceFormat() {
        return SSpaceFormat.SPARSE_BINARY;
    }
    public static void main(String[] args) throws Exception {
        PreComputedWordsiMain main = new PreComputedWordsiMain();
        main.run(args);
    }
}