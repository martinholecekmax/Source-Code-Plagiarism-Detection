public class ForEachBindingTypeTransform extends FreemarkerTransform<BindingTypeLoopStrategy> {
  
  public ForEachBindingTypeTransform(String namespace) {
    super(namespace);
  }
  public BindingTypeLoopStrategy newStrategy() {
    return new BindingTypeLoopStrategy();
  }
}