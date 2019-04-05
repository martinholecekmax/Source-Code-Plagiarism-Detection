public interface ICodanProblemMarker {
	public static final String ID = "id"; 	public static final String CATEGORY = "category"; 	
	public IProblemLocation getLocation();
	
	public IProblem getProblem();
	
	public IResource getResource();
	
	public IMarker createMarker() throws CoreException;
	
	public String createMessage();
	
	public Object[] getArgs();
}