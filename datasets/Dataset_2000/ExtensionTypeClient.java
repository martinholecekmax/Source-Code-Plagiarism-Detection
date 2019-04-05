public class ExtensionTypeClient
        implements IsSerializable {
    
    protected String content;
    
    protected String nameSpace;
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getNameSpace() {
        return nameSpace;
    }
    
    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }
}