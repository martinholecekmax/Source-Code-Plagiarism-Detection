public class RemoteEnvironmentInfoImpl implements IRemoteEnvironmentInfo {
	private EnvironmentInfo getEnvironmentInfo() {
		return Activator.getDefault().getEnvironmentInfo();
	}
	
	public String[] getCommandLineArgs() {
		final EnvironmentInfo ei = getEnvironmentInfo();
		System.out.println("getCommandLineArgs()"); 		return (ei == null) ? null : ei.getCommandLineArgs();
	}
	
	public String[] getFrameworkArgs() {
		final EnvironmentInfo ei = getEnvironmentInfo();
		System.out.println("getFrameworkArgs()"); 		return (ei == null) ? null : ei.getFrameworkArgs();
	}
	
	public String getNL() {
		final EnvironmentInfo ei = getEnvironmentInfo();
		System.out.println("getNL()"); 		return (ei == null) ? null : ei.getNL();
	}
	
	public String[] getNonFrameworkArgs() {
		final EnvironmentInfo ei = getEnvironmentInfo();
		System.out.println("getNonFrameworkArgs()"); 		return (ei == null) ? null : ei.getNonFrameworkArgs();
	}
	
	public String getOS() {
		final EnvironmentInfo ei = getEnvironmentInfo();
		System.out.println("getOS()"); 		return (ei == null) ? null : ei.getOS();
	}
	
	public String getOSArch() {
		final EnvironmentInfo ei = getEnvironmentInfo();
		System.out.println("getOSArch()"); 		return (ei == null) ? null : ei.getOSArch();
	}
	
	public String getWS() {
		final EnvironmentInfo ei = getEnvironmentInfo();
		System.out.println("getWS()"); 		return (ei == null) ? null : ei.getWS();
	}
	
	public Boolean inDebugMode() {
		final EnvironmentInfo ei = getEnvironmentInfo();
		System.out.println("inDebugMode()"); 		return (ei == null) ? null : new Boolean(ei.inDebugMode());
	}
	
	public Boolean inDevelopmentMode() {
		final EnvironmentInfo ei = getEnvironmentInfo();
		System.out.println("inDevelopmentMode()"); 		return (ei == null) ? null : new Boolean(ei.inDevelopmentMode());
	}
}