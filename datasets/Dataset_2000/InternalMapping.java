public interface InternalMapping extends Mapping {
    
    void setName(String name);
    
    void setPath(PropertyPath path);
    
    void setConverter(Converter converter);
    
    void setConverterName(String name);
}