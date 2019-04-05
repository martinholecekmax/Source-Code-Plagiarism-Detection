public final class LoadModulesScript extends AbstractScript<Integer> {
  private final List<File> modules;
  public LoadModulesScript(List<File> modules) throws MojoExecutionException {
    super();
    this.modules = modules;
  }
  @Override
  public String get() {
    String modules = ErlUtils.toModuleList(this.modules, "'", "'");
    return String.format(this.script, modules);
  }
  
  @Override
  public Integer handle(OtpErlangObject result) {
    try {
      return ((OtpErlangLong) result).intValue();
    }
    catch (OtpErlangRangeException e) {
      return -1;
    }
  }
}