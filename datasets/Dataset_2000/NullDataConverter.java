public final class NullDataConverter extends DataConverter {
    private NullDataConverter() {
    }
    @Override
    public <T> T fromData(String content, Class<T> valueType) throws DataConverterException {
        throw new UnsupportedOperationException("not implemented");
    }
    @Override
    public String toData(Object value) throws DataConverterException {
        throw new UnsupportedOperationException("not implemented");
    }
}