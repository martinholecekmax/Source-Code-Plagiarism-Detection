public interface AbstractArrayLink {
    AbstractLinkRef getSourceArray();
    List<? extends AbstractLinkRef> getDestinationIndex();
    AbstractLinkRef getDestinationArray() ;
    AbstractLinkRef getSourceIndex();
    List<?extends AbstractConnection> getConnection();
}