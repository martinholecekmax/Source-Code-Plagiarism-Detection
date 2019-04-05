public class FetchVariantRequest implements Serializable {
	private static final long serialVersionUID = -1617853402478189227L;
	private final ID fromId;
	private final String path;
	private final int type;
	public FetchVariantRequest(ID fromId, String path, int type) {
		this.fromId = fromId;
		this.path = path;
		this.type = type;
	}
	public ID getFromId() {
		return fromId;
	}
	public int getType() {
		return type;
	}
	public String getPath() {
		return path;
	}
	public String toString() {
		StringBuffer buffer = new StringBuffer("FetchVariantRequest["); 		synchronized (buffer) {
			buffer.append("id=").append(fromId); 			buffer.append(";path=").append(path); 			buffer.append(";type=").append(type).append(']'); 			return buffer.toString();
		}
	}
}