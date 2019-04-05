public class SlopQueryNodeBuilder implements StandardQueryBuilder {
  public SlopQueryNodeBuilder() {
      }
  public Query build(QueryNode queryNode) throws QueryNodeException {
    SlopQueryNode phraseSlopNode = (SlopQueryNode) queryNode;
    Query query = (Query) phraseSlopNode.getChild().getTag(
        QueryTreeBuilder.QUERY_TREE_BUILDER_TAGID);
    if (query instanceof PhraseQuery) {
      ((PhraseQuery) query).setSlop(phraseSlopNode.getValue());
    } else {
      ((MultiPhraseQuery) query).setSlop(phraseSlopNode.getValue());
    }
    return query;
  }
}