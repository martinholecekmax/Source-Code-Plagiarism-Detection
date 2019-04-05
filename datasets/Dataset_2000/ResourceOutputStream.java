public class ResourceOutputStream extends OutputStream {
	private final Resource res;
	private final OutputStream os;
	
	public ResourceOutputStream(Resource res, OutputStream os) {
		this.res=res;
		this.os=os;
	}
	
	public void write(int b) throws IOException {
		os.write(b);
	}
	
	public void close() throws IOException {
		try {
			os.close();
		}
		finally {
			res.getResourceProvider().unlock(res);
		}
	}
	
	public void flush() throws IOException {
		os.flush();
	}
	
	public void write(byte[] b, int off, int len) throws IOException {
		os.write(b, off, len);
	}
	
	public void write(byte[] b) throws IOException {
		os.write(b);
	}
	
	public OutputStream getOutputStream() {
		return os;
	}
	
	public Resource getResource() {
		return res;
	}
}