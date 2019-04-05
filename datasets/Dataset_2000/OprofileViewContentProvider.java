public class OprofileViewContentProvider implements ITreeContentProvider {
	public Object[] getChildren(Object element) {
		Assert.isLegal(element instanceof IUiModelElement, "in OprofileViewContentProvider"); 		return ((IUiModelElement) element).getChildren();
	}
	public Object getParent(Object element) {
		Assert.isLegal(element instanceof IUiModelElement, "in OprofileViewContentProvider"); 		return ((IUiModelElement) element).getParent();
	}
	public boolean hasChildren(Object element) {
		Assert.isLegal(element instanceof IUiModelElement, "in OprofileViewContentProvider"); 		return ((IUiModelElement) element).hasChildren();
	}
	public Object[] getElements(Object parentElement) {
		return getChildren(parentElement);
	}
	public void dispose() {
			}
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
}