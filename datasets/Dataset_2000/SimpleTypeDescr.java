public class SimpleTypeDescr extends AbstractDescr {
	private static final long serialVersionUID = 1L;
	String name;
	public SimpleTypeDescr() {
	}
	public SimpleTypeDescr(String fn) {
		name = fn;
		size = 1;
	}
	public void setname(String fn) {
		name = fn;
	}
	public String getName() {
		return name;
	}
	public void print()
	{trace("SimpleTypeDescr: " + name + " size: " + size + " level: " + level);
	unindent();}
}