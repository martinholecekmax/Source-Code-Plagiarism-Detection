public abstract class AbstractSampleStreamFactory<T> implements ObjectStreamFactory<T> {
  protected Class params;
  private AbstractSampleStreamFactory() {
  }
  protected <P> AbstractSampleStreamFactory(Class<P> params) {
    this.params = params;
  }
  public String getLang() {
    return "en";
  }
  @SuppressWarnings({"unchecked"})
  public <P> Class<P> getParameters() {
    return params;
  }
}