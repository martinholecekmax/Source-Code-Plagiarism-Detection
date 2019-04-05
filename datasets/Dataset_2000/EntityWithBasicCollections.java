@Entity
public class EntityWithBasicCollections {
	private Long id;
	private String name;
	private Collection<String> theBag = new ArrayList<String>();
	private Set<String> theSet = new HashSet<String>();
	public EntityWithBasicCollections() {
	}
	public EntityWithBasicCollections(String name) {
		this.name = name;
	}
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ElementCollection
	public Collection<String> getTheBag() {
		return theBag;
	}
	public void setTheBag(Collection<String> theBag) {
		this.theBag = theBag;
	}
	@ElementCollection
	public Set<String> getTheSet() {
		return theSet;
	}
	public void setTheSet(Set<String> theSet) {
		this.theSet = theSet;
	}
}