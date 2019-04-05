public interface EntityStateMachine {
    
    int getState();
    
    void setRecursionMode(int recursionMode);
    
    EntityStateMachine advance() throws IOException, MimeException;
    
    BodyDescriptor getBodyDescriptor() throws IllegalStateException;
    
    InputStream getContentStream() throws IllegalStateException;
    
    Field getField() throws IllegalStateException;
}