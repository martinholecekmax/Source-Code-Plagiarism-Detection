public class QueryIndexField extends AbstractIndexField {
  private static final Logger log = LoggerFactory
      .getLogger(QueryIndexField.class);
  protected IndexSerializationStrategy serializer;
  public QueryIndexField(FieldMetaData fmd) {
    super(fmd, fmd.getName());
    this.serializer = IndexSerializationStrategyFactory
        .getFieldSerializationStrategy(targetField, true);
  }
  @Override
  protected ClassMetaData getContainerClassMetaData(FieldMetaData fmd) {
    return fmd.getDefiningMetaData();
  }
  
  public void addToComposite(DynamicComposite composite, int index,
      Object value, ComponentEquality equality) {
    log.debug("Adding value {} to composite: {} ", value, composite);
    this.serializer.addToComponent(composite, index, value, equality);
  }
  @Override
  protected IndexSerializationStrategy getSerializationStrategy() {
    return serializer;
  }
}