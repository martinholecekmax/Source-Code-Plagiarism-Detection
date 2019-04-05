public class Tagable {
	
	private Object _tag;
	
	public Tagable() {
		_tag = null;
	}
	
	public void setTag(Object value) {
		_tag = value;
	}
	
	public Object getTag() {
		return _tag;
	}
	
	public boolean hasTag() {
		return (_tag != null);
	}
}