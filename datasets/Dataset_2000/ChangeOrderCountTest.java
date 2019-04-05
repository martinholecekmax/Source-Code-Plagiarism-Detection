public abstract class ChangeOrderCountTest extends TestCase {
	
	protected ChangeOrderCount fixture = null;
	
	public ChangeOrderCountTest(String name) {
		super(name);
	}
	
	protected void setFixture(ChangeOrderCount fixture) {
		this.fixture = fixture;
	}
	
	protected ChangeOrderCount getFixture() {
		return fixture;
	}
}