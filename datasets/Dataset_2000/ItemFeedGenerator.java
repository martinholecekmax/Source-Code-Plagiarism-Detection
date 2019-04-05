public interface ItemFeedGenerator {
    
    public void setFilter(NoteItemFilter filter);
    
    public Feed generateFeed(CollectionItem item)
        throws GeneratorException;
    
    public Feed generateFeed(NoteItem item)
        throws GeneratorException;
    
    public Entry generateEntry(NoteItem item)
        throws GeneratorException;
}