public class PWatchpoint extends PBreakpoint implements IPWatchpoint {
	private static final String P_WATCHPOINT = "org.eclipse.ptp.debug.core.pWatchpointMarker"; 	
	public static String getMarkerType() {
		return P_WATCHPOINT;
	}
	public PWatchpoint() {
	}
	public PWatchpoint(IResource resource, Map<String, ? extends Object> attributes, final String jobId, final String setId,
			boolean add) throws CoreException {
		super(resource, getMarkerType(), attributes, jobId, setId, add);
	}
	
	public int getCharEnd() throws CoreException {
		return ensureMarker().getAttribute(IMarker.CHAR_END, -1);
	}
	
	public int getCharStart() throws CoreException {
		return ensureMarker().getAttribute(IMarker.CHAR_START, -1);
	}
	
	public String getExpression() throws CoreException {
		return ensureMarker().getAttribute(EXPRESSION, ""); 	}
	
	public int getLineNumber() throws CoreException {
		return ensureMarker().getAttribute(IMarker.LINE_NUMBER, -1);
	}
	
	public boolean isReadType() throws CoreException {
		return ensureMarker().getAttribute(READ, false);
	}
	
	public boolean isWriteType() throws CoreException {
		return ensureMarker().getAttribute(WRITE, true);
	}
	
	@Override
	protected String getMarkerMessage() throws CoreException {
		String format = Messages.PWatchpoint_0;
		if (isWriteType() && !isReadType()) {
			format = Messages.PWatchpoint_1;
		} else if (!isWriteType() && isReadType()) {
			format = Messages.PWatchpoint_2;
		} else if (isWriteType() && isReadType()) {
			format = Messages.PWatchpoint_3;
		}
		return getJobSetFormat() + " " + NLS.bind(Messages.PWatchpoint_4, new Object[] { format }); 	}
}