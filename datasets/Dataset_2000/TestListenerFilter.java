public class TestListenerFilter implements ClassFilter.ClassFilterWithScope
{
  private final GlobalSearchScope scope;
  private final Project project;
  public TestListenerFilter(GlobalSearchScope scope, Project project) {
    this.scope = scope;
    this.project = project;
  }
  public boolean isAccepted(final PsiClass psiClass) {
    return ApplicationManager.getApplication().runReadAction(new Computable<Boolean>() {
      @Override
      public Boolean compute() {
        if (!ConfigurationUtil.PUBLIC_INSTANTIATABLE_CLASS.value(psiClass)) return false;
        return TestNGUtil.inheritsITestListener(psiClass);
      }
    });
  }
  public Project getProject() {
    return project;
  }
  public GlobalSearchScope getScope() {
    return scope;
  }
}