public class Class0101Sub extends Class0101 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String PROP_ID = "id";
    
    private String id;
	
	public Class0101Sub() {
		super();
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(final String id) {
		this.id = id;
	}	
	
	public boolean equals(final Object other) {
	 			if (this == other) {
			return true;
		}
		if (id==null) {
			return false;
		}
		if (!(other instanceof Class0101Sub)) {
			return false;
		}
		final Class0101Sub castedOther = (Class0101Sub) other;
		if (id != null && castedOther.getId() != null) {
			return id.equals(castedOther.getId());
		}
		return true;
		 	}
	
	public int hashCode() {
		return id==null ? System.identityHashCode(this) : id.hashCode();
	}
			}