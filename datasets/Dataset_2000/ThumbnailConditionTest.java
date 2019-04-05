public class ThumbnailConditionTest {
	private UriRef uri = new UriRef ("http:	private static final byte[] input = "<img href=\"/thumbnail-service?uri=http:	@Test
	public void thumbnailConditionTest() throws IOException {
		ByteArrayOutputStream bous = new ByteArrayOutputStream();
		OutputStream out = new ConditionalOutputStream(bous,
				new ThumbnailCondition(new ThumbnailService() {
			@Override
			public UriRef getThumbnailUri(UriRef infoBitUri, Integer width, Integer height, boolean exact) {
				Assert.assertEquals(uri, infoBitUri);
				Assert.assertEquals(Integer.valueOf(700), width);
				Assert.assertEquals(Integer.valueOf(300), height);
				Assert.assertEquals(true, exact);
				return new UriRef("http:			}				
		}));
		out.write(input);
		Assert.assertEquals("<img href=\"http:	}
}