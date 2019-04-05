public final class EditPartUtilities {
	private EditPartUtilities() {
					}
	
	public static LinkedHashSet getAllChildren(GraphicalEditPart parentEditPart) {
		LinkedHashSet transitiveChildren = new LinkedHashSet();
		List children = parentEditPart.getChildren();
		transitiveChildren.addAll(children);
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			GraphicalEditPart child = (GraphicalEditPart) iterator.next();
			transitiveChildren.addAll(getAllChildren(child));
		}
		return transitiveChildren;
	}
	
	public static HashSet getAllNestedConnectionEditParts(
			GraphicalEditPart graphicalEditPart) {
		HashSet transitiveConnections = new HashSet();
		HashSet transitiveChildren = getAllChildren(graphicalEditPart);
		for (Iterator iterator = transitiveChildren.iterator(); iterator
				.hasNext();) {
			GraphicalEditPart child = (GraphicalEditPart) iterator.next();
			transitiveConnections.addAll(child.getSourceConnections());
			transitiveConnections.addAll(child.getTargetConnections());
		}
		return transitiveConnections;
	}
	
	public static HashSet getNestedConnectionEditParts(
			GraphicalEditPart graphicalEditPart) {
		HashSet edges = new HashSet();
		List children = graphicalEditPart.getChildren();
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			Object child = iterator.next();
			if (child instanceof GraphicalEditPart) {
				GraphicalEditPart childEditPart = (GraphicalEditPart) child;
				edges.addAll(childEditPart.getSourceConnections());
				edges.addAll(childEditPart.getTargetConnections());
			}
		}
		return edges;
	}
}