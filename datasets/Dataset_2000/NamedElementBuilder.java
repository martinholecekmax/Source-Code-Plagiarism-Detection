public abstract class NamedElementBuilder {
	private String name;
	public void clear() {
		name = null;
	}
	public String getName() {
		return name;
	}
	public void initFrom(String n) {
		clear();
		this.name = n;
	}
	public void setName(String name) {
		this.name = name;
	}
}