public class PluralPronounResolver extends MaxentResolver {
  int NUM_SENTS_BACK_PRONOUNS = 2;
  public PluralPronounResolver(String projectName, ResolverMode m) throws IOException {
    super(projectName, "tmodel", m, 30);
  }
  public PluralPronounResolver(String projectName, ResolverMode m,NonReferentialResolver nrr) throws IOException {
    super(projectName, "tmodel", m, 30,nrr);
  }
  @Override
  protected List<String> getFeatures(MentionContext mention, DiscourseEntity entity) {
    List<String> features = new ArrayList<String>();
    features.addAll(super.getFeatures(mention,entity));
        if (entity != null) {       features.addAll(ResolverUtils.getPronounMatchFeatures(mention,entity));
      MentionContext cec = entity.getLastExtent();
      features.addAll(ResolverUtils.getDistanceFeatures(mention,entity));
      features.addAll(ResolverUtils.getContextFeatures(cec));
      features.add(ResolverUtils.getMentionCountFeature(entity));
      
    }
    return (features);
  }
  @Override
  protected boolean outOfRange(MentionContext mention, DiscourseEntity entity) {
    MentionContext cec = entity.getLastExtent();
        return (mention.getSentenceNumber() - cec.getSentenceNumber() > NUM_SENTS_BACK_PRONOUNS);
  }
  public boolean canResolve(MentionContext mention) {
    String tag = mention.getHeadTokenTag();
    return (tag != null && tag.startsWith("PRP") && ResolverUtils.pluralThirdPersonPronounPattern.matcher(mention.getHeadTokenText()).matches());
  }
}