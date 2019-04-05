public class SimulationModel {
	private String m_path=null;
	private byte[] m_contents=null;
	
	public SimulationModel(String path, java.io.InputStream is) throws Exception {
		m_path = path;
		if (is != null) {
			m_contents = new byte[is.available()];
			is.read(m_contents);
		}
	}
	
	public String getName() {
		return(m_path);
	}
	
	public java.io.InputStream getContents() {
		java.io.InputStream ret=null;
		if (m_contents != null) {
			ret = new java.io.ByteArrayInputStream(m_contents);
		}
		return(ret);
	}
}