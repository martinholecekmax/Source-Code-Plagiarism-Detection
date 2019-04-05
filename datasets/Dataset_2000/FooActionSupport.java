public class FooActionSupport extends ContentActionSupport {
	protected Foo foo;
	public Foo getFoo() {
		return foo;
	}
	public void setFoo(Foo foo) {
		this.foo = foo;
	}
    public boolean isFollowed() {
        return followingManager.isFollowed(getUser(), new EntityDescriptor(foo));
    }
}