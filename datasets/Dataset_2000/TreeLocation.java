public interface TreeLocation {
    
    @Nonnull
    TreeLocation getParent();
    
    @Nonnull
    TreeLocation getChild(String relPath);
    
    @CheckForNull
    Tree getTree();
    
    @CheckForNull
    PropertyState getProperty();
    
    @CheckForNull
    Status getStatus();
    
    @CheckForNull
    String getPath();
}