public class InputStreamReaderSource extends AbstractReaderSource {
    private InputStream stream;      
    public InputStreamReaderSource(InputStream stream, CompilerConfiguration configuration) {
        super(configuration);
        this.stream = stream;
    }
    
    public Reader getReader() throws IOException {
        if (stream != null) {
            Reader reader = new InputStreamReader(stream, configuration.getSourceEncoding());
            stream = null;
            return reader;
        }
        return null;
    }
    
    public boolean canReopenSource() {
        return false;
    }
}