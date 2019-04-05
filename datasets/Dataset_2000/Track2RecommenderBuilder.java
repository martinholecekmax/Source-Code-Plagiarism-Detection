final class Track2RecommenderBuilder implements RecommenderBuilder {
  @Override
  public Recommender buildRecommender(DataModel dataModel) throws TasteException {
    return new Track2Recommender(dataModel, ((KDDCupDataModel) dataModel).getDataFileDirectory());
  }
}