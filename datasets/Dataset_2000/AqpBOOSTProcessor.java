public class AqpBOOSTProcessor extends QueryNodeProcessorImpl implements
		QueryNodeProcessor {
	@Override
	protected QueryNode preProcessNode(QueryNode node)
			throws QueryNodeException {
		if (node instanceof AqpANTLRNode && ((AqpANTLRNode) node).getTokenLabel().equals("BOOST")) {
			if (node.getChildren().size()==1) {
				return node.getChildren().get(0);
			}
			Float boost = getBoostValue(node);
			if (boost==null) {
				return node.getChildren().get(node.getChildren().size()-1);
			}
			return new BoostQueryNode(node.getChildren().get(node.getChildren().size()-1), boost);
		}
		return node;
	}
	@Override
	protected QueryNode postProcessNode(QueryNode node)
			throws QueryNodeException {
		return node;
	}
	@Override
	protected List<QueryNode> setChildrenOrder(List<QueryNode> children)
			throws QueryNodeException {
		return children;
	}
	private Float getBoostValue(QueryNode boostNode) throws QueryNodeException {
		if (boostNode.getChildren()!=null) {
			AqpANTLRNode child = ((AqpANTLRNode) boostNode.getChildren().get(0));
			String input = child.getTokenInput();
			float boost;
			if (input.equals("^")) {
				QueryConfigHandler queryConfig = getQueryConfigHandler();
				if (queryConfig == null || !queryConfig.hasAttribute(BoostAttribute.class)) {
					throw new QueryNodeException(new MessageImpl(
			                QueryParserMessages.LUCENE_QUERY_CONVERSION_ERROR,
			                "Configuration error: " + BoostAttribute.class.toString() + " is missing"));
				}
				boost = queryConfig.getAttribute(BoostAttribute.class).getBoost();
			}
			else {
				boost = Float.valueOf(input.replace("^", ""));
			}
			return boost;
		}
		return null;
	}
}