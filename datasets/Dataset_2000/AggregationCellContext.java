public class AggregationCellContext extends BasicCellContext {
  public static final Object LINK_DECLARATION = new Object();
  public static final Object CURRENT_CHILD_NODE = new Object();
  public AggregationCellContext(SNode parentNode, SNode currentChild, SNode linkDeclaration) {
    super(parentNode);
    put(LINK_DECLARATION, linkDeclaration);
    put(CURRENT_CHILD_NODE, currentChild);
  }
}