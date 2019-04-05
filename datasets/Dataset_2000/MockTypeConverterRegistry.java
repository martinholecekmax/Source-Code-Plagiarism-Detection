public class MockTypeConverterRegistry implements TypeConverterRegistry {
    private List<TypeConverter> typeConverters = new ArrayList<TypeConverter>();
    private List<TypeConverter> fallbackTypeConverters = new ArrayList<TypeConverter>();
    public List<TypeConverter> getTypeConverters() {
        return typeConverters;
    }
    public List<TypeConverter> getFallbackTypeConverters() {
        return fallbackTypeConverters;
    }
    public void addTypeConverter(Class<?> toType, Class<?> fromType, TypeConverter typeConverter) {
        typeConverters.add(typeConverter);
    }
    public void addFallbackTypeConverter(TypeConverter typeConverter, boolean canPromote) {
        fallbackTypeConverters.add(typeConverter);
    }
    public TypeConverter lookup(Class<?> toType, Class<?> fromType) {       
        return null;
    }
    public void setInjector(Injector injector) {
           }
    public Injector getInjector() {
        return null;
    }
    public Statistics getStatistics() {
        return null;
    }
    public void start() throws Exception {
            }
    public void stop() throws Exception {
            }
}