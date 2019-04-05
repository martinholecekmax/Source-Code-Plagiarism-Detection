public class DataProcessorImpl implements IDataProcessor {
	private ID containerID;
	public DataProcessorImpl(ID containerID) {
		this.containerID = containerID;
	}
	
	public String processData(String data) {
		System.out.println("DataProcessorImpl(" + containerID.getName()
				+ ").processData data=" + data);
		if (data == null) return null;
		return reverseString(data);
	}
	private String reverseString(String data) {
		StringBuffer buf = new StringBuffer(data);
		buf.reverse();
		return buf.toString();
	}
	public void stop() {
	}
}