public interface IRemoteProxyManager {
	String EXTENSION_POINT_ID = "RemoteProxyManager"; 	String MANAGER_NAME = "manager"; 	String SCHEME_ID = "scheme"; 	public IRemoteFileProxy getFileProxy(IProject project) throws CoreException;
	public IRemoteFileProxy getFileProxy(URI uri) throws CoreException;
	public IRemoteCommandLauncher getLauncher(IProject project) throws CoreException;
	public IRemoteCommandLauncher getLauncher(URI uri) throws CoreException;
	public String getOS(IProject project) throws CoreException;
	public String getOS(URI uri) throws CoreException;
}