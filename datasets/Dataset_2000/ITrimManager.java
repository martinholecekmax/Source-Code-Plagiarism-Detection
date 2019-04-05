public interface ITrimManager {
	
	public static final int TOP = SWT.TOP;
	
	public static final int BOTTOM = SWT.BOTTOM;
	
	public static final int LEFT = SWT.LEFT;
	
	public static final int RIGHT = SWT.RIGHT;
	
	public static final int NONTRIM = SWT.DEFAULT;
	
	public void addTrim(int areaId, IWindowTrim trim);
	
	public void addTrim(int areaId, IWindowTrim trim, IWindowTrim beforeMe);
	
	public void removeTrim(IWindowTrim toRemove);
	
	public IWindowTrim getTrim(String id);
	
	public int[] getAreaIds();
	
	public List getAreaTrim(int areaId);
	
	public void updateAreaTrim(int id, List trim, boolean removeExtra);
	
	public List getAllTrim();
	
	public void setTrimVisible(IWindowTrim trim, boolean visible);
	
	public void forceLayout();
}