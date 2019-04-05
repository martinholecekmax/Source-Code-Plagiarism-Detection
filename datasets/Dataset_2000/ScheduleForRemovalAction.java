public class ScheduleForRemovalAction extends AbstractMissingFilesAction {
  protected List<VcsException> processFiles(final AbstractVcs vcs, final List<FilePath> files) {
    CheckinEnvironment environment = vcs.getCheckinEnvironment();
    if (environment == null) return Collections.emptyList();
    final List<VcsException> result = environment.scheduleMissingFileForDeletion(files);
    if (result == null) return Collections.emptyList();
    return result;
  }
  protected String getName() {
    return null;
  }
  protected boolean synchronously() {
    return true;
  }
}