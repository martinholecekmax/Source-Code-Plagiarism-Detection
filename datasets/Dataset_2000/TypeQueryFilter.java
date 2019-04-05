public class TypeQueryFilter extends RawFieldQueryFilter {
  private Configuration conf;
  public TypeQueryFilter() {
    super("type");
  }
  public void setConf(Configuration conf) {
    this.conf = conf;
    setBoost(conf.getFloat("query.type.boost", 0.0f));
  }
  public Configuration getConf() {
    return this.conf;
  }
}