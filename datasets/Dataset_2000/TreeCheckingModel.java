public interface TreeCheckingModel {
    
    public enum CheckingMode {
    
    SIMPLE,
    
    PROPAGATE,
    
    PROPAGATE_UP_UNCHECK,
    
    PROPAGATE_PRESERVING_UNCHECK,
    
    PROPAGATE_PRESERVING_CHECK
    }
    
    public boolean isPathChecked(TreePath path);
    
    public boolean isPathEnabled(TreePath path);
    
    public boolean isPathGreyed(TreePath path);
    
    public void toggleCheckingPath(TreePath pathForRow);
    
    public void addCheckingPath(TreePath path);
    
    public void addCheckingPaths(TreePath[] paths);
    
    public void removeCheckingPath(TreePath path);
    
    public void removeCheckingPaths(TreePath[] paths);
    
    public void setPathEnabled(TreePath path, boolean enable);
    
    public void setPathsEnabled(TreePath[] paths, boolean enable);
    
    public TreePath[] getCheckingPaths();
    
    public TreePath[] getCheckingRoots();
    
    public TreePath[] getGreyingPaths();
    
    public void setCheckingPaths(TreePath[] paths);
    
    public void setCheckingPath(TreePath path);
    
    public void clearChecking();
    
    public void setCheckingMode(CheckingMode mode);
    
    public CheckingMode getCheckingMode();
    
    @Deprecated
    public TreeModelListener getTreeModelListener();
    
    public void addTreeCheckingListener(TreeCheckingListener x);
    
    public void removeTreeCheckingListener(TreeCheckingListener x);
    
    public TreeModel getTreeModel();
    
    public void setTreeModel(TreeModel model);
}