public class ReaderRepresentation extends CharacterRepresentation {
    
    private volatile Reader reader;
    
    public ReaderRepresentation(Reader reader) {
        this(reader, null);
    }
    
    public ReaderRepresentation(Reader reader, MediaType mediaType) {
        this(reader, mediaType, UNKNOWN_SIZE);
    }
    
    public ReaderRepresentation(Reader reader, MediaType mediaType,
            long expectedSize) {
        super(mediaType);
        setSize(expectedSize);
        setTransient(true);
        setReader(reader);
    }
    @Override
    public Reader getReader() throws IOException {
        final Reader result = this.reader;
        setReader(null);
        return result;
    }
    
    @Override
    public String getText() throws IOException {
        return BioUtils.toString(getStream(), getCharacterSet());
    }
    
    @Override
    public void release() {
        if (this.reader != null) {
            try {
                this.reader.close();
            } catch (IOException e) {
                Context.getCurrentLogger().log(Level.WARNING,
                        "Error while releasing the representation.", e);
            }
            this.reader = null;
        }
        super.release();
    }
    
    public void setReader(Reader reader) {
        this.reader = reader;
        setAvailable(reader != null);
    }
    @Override
    public void write(Writer writer) throws IOException {
        BioUtils.copy(getReader(), writer);
    }
}