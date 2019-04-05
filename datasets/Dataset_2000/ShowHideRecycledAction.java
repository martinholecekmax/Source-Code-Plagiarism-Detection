public class ShowHideRecycledAction extends AnAction {
  @Override
  public void update(final AnActionEvent e) {
    final Project project = e.getData(PlatformDataKeys.PROJECT);
    final Presentation presentation = e.getPresentation();
    if (project == null) {
      presentation.setEnabled(false);
      presentation.setVisible(false);
    }
    presentation.setEnabled(true);
    presentation.setVisible(true);
    final boolean show = ShelveChangesManager.getInstance(project).isShowRecycled();
    presentation.setText(show ? "Hide Already Unshelved" : "Show Already Unshelved");
  }
  public void actionPerformed(final AnActionEvent e) {
    final Project project = e.getData(PlatformDataKeys.PROJECT);
    if (project == null) {
      return;
    }
    final ShelveChangesManager manager = ShelveChangesManager.getInstance(project);
    final boolean show = manager.isShowRecycled();
    manager.setShowRecycled(! show);
  }
}