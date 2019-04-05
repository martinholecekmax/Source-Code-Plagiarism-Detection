public class TextFileAdapter extends BasePropertyFileAdapter {
    private static ValueCodec XML_VALUE_CODEC = new DummyValueCodec();
    public TextFileAdapter() {
        super(XML_VALUE_CODEC, false, false);
    }
    @Override
    protected void loadFromFile(Properties props, InputStream input) throws IOException {
        throw new UnsupportedOperationException();
    }
    @Override
    protected void saveToFile(Properties props, OutputStream output, String comment)
        throws IOException {
        throw new UnsupportedOperationException();
    }
}