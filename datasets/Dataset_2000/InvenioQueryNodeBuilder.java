public class InvenioQueryNodeBuilder implements StandardQueryBuilder {
	private QueryBuilder master;
	public InvenioQueryNodeBuilder(QueryBuilder parentBuilder) {
		master = parentBuilder;
	}
	public Query build(QueryNode queryNode) throws QueryNodeException {
		InvenioQueryNode iq = (InvenioQueryNode) queryNode;
		QueryNode q = iq.getChild();
		if (iq.getChannel() == Channel.INTBITSET ) {
			return new InvenioQueryBitSet((Query) master.build(q), iq.getIdField(), iq.getSearchField());
		}
		else {
			return new InvenioQuery((Query) master.build(q), iq.getIdField(), iq.getSearchField());
		}
	  }
}