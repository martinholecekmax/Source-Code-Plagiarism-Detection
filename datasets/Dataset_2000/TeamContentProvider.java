public class TeamContentProvider implements ITreeContentProvider {
	private static final Object[] EMPTY_OBJECT = new Object[0];
	private static TeamContentProvider instance;
	
	public static TeamContentProvider getInstance() {
		synchronized (TeamContentProvider.class) {
			if (instance == null) {
				instance = new TeamContentProvider();
			}
			return instance;
		}
	}
	
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Object[]) {
			return (Object[]) inputElement;
		}
		if (inputElement instanceof Collection) {
			return ((Collection) inputElement).toArray();
		}
		return EMPTY_OBJECT;
	}
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Team) {
			return ((Team) parentElement).getPersons().toArray();
		}
		return EMPTY_OBJECT;
	}
	public Object getParent(Object element) {
		return null;
	}
	public boolean hasChildren(Object element) {
		if (element instanceof Team) {
			return ((Team) element).getPersons().size() > 0;
		}
		return false;
	}
	public void dispose() {
	}
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}