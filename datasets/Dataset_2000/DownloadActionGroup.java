public class DownloadActionGroup extends DefaultActionGroup implements DumbAware {
  @Override
  public void update(AnActionEvent e) {
    super.update(e);
    e.getPresentation().setEnabled(isEnabled(e));
  }
  private boolean isEnabled(AnActionEvent e) {
    return MavenActionUtil.hasProject(e.getDataContext())
           && MavenActionUtil.getProjectsManager(e.getDataContext()).isMavenizedProject();
  }
}