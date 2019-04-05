public class CanCutNodeFilter extends UIExtensionAbstractFilter {
  public CanCutNodeFilter() {
    this("UIPopupMenu.msg.can-not-cut-node");
  }
  public CanCutNodeFilter(String messageKey) {
    super(messageKey, UIExtensionFilterType.MANDATORY);
  }
  public boolean accept(Map<String, Object> context) throws Exception {
    if (context == null) return true;
    Node currentNode = (Node) context.get(Node.class.getName());
    return PermissionUtil.canRemoveNode(currentNode) && (!IsVersionableOrAncestorFilter.isAncestorVersionable(currentNode) ||
            (IsVersionableOrAncestorFilter.isAncestorVersionable(currentNode) && IsCheckedOutFilter.isCheckedOut(currentNode)));
  }
  public void onDeny(Map<String, Object> context) throws Exception {
    createUIPopupMessages(context, "UIPopupMenu.msg.can-not-cut-node");
  }
}