public class DisplayWithId {
	private String display;
	private String id;
	
	public DisplayWithId(String display, String id) {
		this.display = display;
		this.id = id;
	}
	
	public String toString() {
		return this.display;
	}
	
	public String getId() {
		return this.id;
	}
}