public class ModuleUrl extends AbstractUrl {
  @NonNls private static final String ELEMENT_TYPE = "module";
  public ModuleUrl(String url, String moduleName) {
    super(url, moduleName,ELEMENT_TYPE);
  }
  @Override
  public Object[] createPath(Project project) {
    final Module module = moduleName != null ? ModuleManager.getInstance(project).findModuleByName(moduleName) : null;
    if (module == null) return null;
    return new Object[]{module};
  }
  @Override
  protected AbstractUrl createUrl(String moduleName, String url) {
      return new ModuleUrl(url, moduleName);
  }
  @Override
  public AbstractUrl createUrlByElement(Object element) {
    if (element instanceof Module) {
      Module module = (Module)element;
      return new ModuleUrl("", module.getName());
    }
    return null;
  }
}