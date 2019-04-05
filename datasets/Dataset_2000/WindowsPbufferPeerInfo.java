final class WindowsPbufferPeerInfo extends WindowsPeerInfo {
	WindowsPbufferPeerInfo(int width, int height, PixelFormat pixel_format, IntBuffer pixelFormatCaps, IntBuffer pBufferAttribs) throws LWJGLException {
		nCreate(getHandle(), width, height, pixel_format, pixelFormatCaps, pBufferAttribs);
	}
	private static native void nCreate(ByteBuffer handle, int width, int height, PixelFormat pixel_format, IntBuffer pixelFormatCaps, IntBuffer pBufferAttribs) throws LWJGLException;
	public boolean isBufferLost() {
		return nIsBufferLost(getHandle());
	}
	private static native boolean nIsBufferLost(ByteBuffer handle);
	public void setPbufferAttrib(int attrib, int value) {
		nSetPbufferAttrib(getHandle(), attrib, value);
	}
	private static native void nSetPbufferAttrib(ByteBuffer handle, int attrib, int value);
	public void bindTexImageToPbuffer(int buffer) {
		nBindTexImageToPbuffer(getHandle(), buffer);
	}
	private static native void nBindTexImageToPbuffer(ByteBuffer handle, int buffer);
	public void releaseTexImageFromPbuffer(int buffer) {
		nReleaseTexImageFromPbuffer(getHandle(), buffer);
	}
	private static native void nReleaseTexImageFromPbuffer(ByteBuffer handle, int buffer);
	public void destroy() {
		nDestroy(getHandle());
	}
	private static native void nDestroy(ByteBuffer handle);
	protected void doLockAndInitHandle() throws LWJGLException {
			}
	protected void doUnlock() throws LWJGLException {
			}
}