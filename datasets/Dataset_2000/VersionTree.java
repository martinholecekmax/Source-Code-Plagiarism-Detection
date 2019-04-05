public class VersionTree extends BasicAction {
  private static final Logger log=Logger.getInstance("#"+VersionTree.class.getName());
  private static final String NAME=Bundle.getString("versiontree.action.name");
  public VersionTree() {
    super(NAME);
  }
  @Override
  public boolean perform(@NotNull final Project project, Vcs vcs, @NotNull final List<VcsException> exceptions, @NotNull VirtualFile[] files) {
    for(VirtualFile vf:files) {
      FileStatus fileStatus = FileStatusManager.getInstance(project).getStatus(vf);
      if(fileStatus!=FileStatus.IGNORED && fileStatus!=FileStatus.UNKNOWN)
        try {
          VirtualFile root;
          root=Util.getRoot(vf);
          if(vf.isDirectory() && root.equals(vf))
            root=vf.getParent();
                    LineHandler handler=new LineHandler(project,root,Command.VERSION_TREE_GRAPHICAL);
          handler.endOptions();
          handler.addParameters(vf.getName()+"@@");
          handler.start();
        } catch(VcsException e) {
          exceptions.add(e);
          log.error(e);
        }
    }
    Util.refreshFiles(project,Arrays.asList(files));     return true;
  }
  @Override
  @NotNull
  protected String getActionName() {
    return NAME;
  }
  @Override
  protected boolean isEnabled(@NotNull Project project, @NotNull Vcs vcs, @NotNull VirtualFile... vFiles) {
    for (VirtualFile file : vFiles) {
      FileStatus fileStatus = FileStatusManager.getInstance(project).getStatus(file);
      if(fileStatus!=FileStatus.IGNORED && fileStatus!=FileStatus.UNKNOWN)
        return true;
    }
    return false;
  }
}