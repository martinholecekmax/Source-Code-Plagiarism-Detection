public class HistoryInformationTest extends FreeMindTestBase {
	private HistoryInformation info;
	protected void setUp() throws Exception {
		super.setUp();
		info = new HistoryInformation();
	}
	public void testGetCreatedAt() {
		Date now = new Date();
		info = new HistoryInformation(now, now);
		assertEquals(now, info.getCreatedAt());
	}
	public void testGetLastModifiedAt() {
		Date now = new Date();
		info = new HistoryInformation(now, now);
		assertEquals(now, info.getLastModifiedAt());
	}
}