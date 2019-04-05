public class SpaceTreeNode extends TreeNode {
  public SpaceTreeNode(String name) throws Exception {
    super(name, TreeNodeType.SPACE);
    this.path = buildPath();
    this.hasChild = Utils.getWikisByType(WikiType.valueOf(name.toUpperCase())).size() > 0;
  }  
  @Override
  protected void addChildren(HashMap<String, Object> context) throws Exception {
    Collection<Wiki> wikis = Utils.getWikisByType(WikiType.valueOf(name.toUpperCase()));
    Iterator<Wiki> childWikiIterator = wikis.iterator();
    int count = 0;
    int size = getNumberOfChildren(context, wikis.size());
    while (childWikiIterator.hasNext() && count < size) {
      WikiTreeNode child = new WikiTreeNode(childWikiIterator.next());
      this.children.add(child);
      count++;
    }
    super.addChildren(context);
  }
  public WikiTreeNode getChildByName(String name) throws Exception {
    for (TreeNode child : children) {
      if (child.getName().equals(name))
        return (WikiTreeNode)child;
    }
    return null;
  }
  @Override
  public String buildPath() {
    return TreeUtils.getPathFromPageParams(new WikiPageParams(this.name, null, null));
  }
}