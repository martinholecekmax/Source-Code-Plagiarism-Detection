public final class XQUTS extends W3CTS {
  
  public static void main(final String[] args) throws Exception {
    new XQUTS().run(args);
  }
  
  public XQUTS() {
    super(Util.name(XQUTS.class));
    context.prop.set(Prop.FORCECREATE, true);
  }
  @Override
  protected Nodes states(final Nodes root) throws QueryException {
    return nodes("*:state", root);
  }
  @Override
  protected boolean updating() {
    return true;
  }
}