public class JavaDefaultLiveTemplatesProvider implements DefaultLiveTemplatesProvider {
  private static final @NonNls String[] DEFAULT_TEMPLATES = new String[]{
    "/liveTemplates/iterations",
    "/liveTemplates/other",
    "/liveTemplates/output",
    "/liveTemplates/plain",
    "/liveTemplates/surround"
  };
  public String[] getDefaultLiveTemplateFiles() {
    return DEFAULT_TEMPLATES;
  }
  @Override
  public String[] getHiddenLiveTemplateFiles() {
    return null;
  }
}