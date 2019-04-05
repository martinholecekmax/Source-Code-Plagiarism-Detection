@SuppressWarnings("restriction")
public class C99Label extends PlatformObject implements IC99Binding, ILabel {
	private String name;
	private IScope scope;
	public C99Label() {
	}
	public C99Label(String name) {
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public char[] getNameCharArray() {
		return name.toCharArray();
	}
	public IASTLabelStatement getLabelStatement() {
		return null;
	}
	public ILinkage getLinkage() {
		return Linkage.C_LINKAGE;
	}
	public IScope getScope() {
		return scope;
	}
	public void setScope(IScope scope) {
		this.scope = scope;
	}
	public IBinding getOwner() {
		if (scope != null) {
			return CVisitor.findEnclosingFunction((IASTNode) scope.getScopeName()); 		}
		return null;
	}
}