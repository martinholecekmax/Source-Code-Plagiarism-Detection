public class ClassFieldTreeProvider implements ITreeContentProvider {
    private IClassDefAdapter rootClass;
    public ClassFieldTreeProvider(IClassDefAdapter rootClass) {
        this.rootClass = rootClass;
    }
    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof ITreeNode) {
            return ((ITreeNode) parentElement).getChildren();
        }
        return null;
    }
    public Object getParent(Object element) {
        return null;
    }
    public boolean hasChildren(Object element) {
        if (element instanceof ITreeNode) {
            ITreeNode node = (ITreeNode) element;
            return node.hasChildren();
        }
        return false;
    }
    public Object[] getElements(Object inputElement) {
        return new Object[] { new TreeNodeClassField(rootClass) };
    }
    public void dispose() {
    }
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
}