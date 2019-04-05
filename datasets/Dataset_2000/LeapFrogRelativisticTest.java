public class LeapFrogRelativisticTest extends SolverTest {
	
	public LeapFrogRelativisticTest(String testName) {
		super(testName);
		solver = new LeapFrogRelativistic(ConstantsSI.c);
	}
	
	public static Test suite() {
		return new TestSuite(LeapFrogRelativisticTest.class);
	}
}