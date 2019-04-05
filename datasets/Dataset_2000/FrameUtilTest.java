public class FrameUtilTest extends TestCase {
	FrameUtil util;
	@Override
	protected void setUp() throws Exception {
		util = new FrameUtil();
		super.setUp();
	}
	public void testExtractFrames_AllFrames() {
		assertEquals(5,
				util.extractFrames(createFrameList(5)).size());
	}
	public void testExtractFrames_SkipOne() {
		final List<String> frames = createFrameList(5);
		frames.add("folder/non-frame.png");
		assertEquals(5, util.extractFrames(frames).size());
	}
	public void testExtractFrames_NoFrames() {
		final List<String> frames =
				new ArrayList<String>(Arrays.
						asList(new String[] {"file1", "file2"}));
		try {
			util.extractFrames(frames);
			fail();
		} catch (final AniDroidException e) { }
	}
	public List<String> createFrameList(final int capacity) {
		final List<String> frames = new ArrayList<String>();
		for (int i = 0; i < capacity; i++) {
			frames.add(String.format("folder/frame-%d.png", i));
		}
		return frames;
	}
}