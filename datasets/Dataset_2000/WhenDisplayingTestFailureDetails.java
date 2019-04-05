public class WhenDisplayingTestFailureDetails {
	protected Collection<StackTraceElement> actualStackTrace;
	private ErrorViewerResolution resolution;
	protected String actualMessage;
	@Before
	public void inContext() {
		actualStackTrace = newArrayList();
		resolution = new ErrorViewerResolution("TestName.methodName") {
			@Override
			protected void createStackViewWith(List<StackTraceElement> trace, String message) {
				actualStackTrace = trace;
				actualMessage = message;
			}
		};
	}
	@Test
	public void shouldUseTestAndMethodNameInLabel() {
		assertEquals("TestName.methodName failing (see details)", resolution.getLabel());
	}
	@Test
	public void printStackTraceWithSourceFileLinksUsingInternalJavaStackTraceConsole() throws Exception {
		IMarker marker = mock(IMarker.class);
		StackTraceElement element = new StackTraceElement("", "", "", 0);
		Object pickledStackTrace = pickle(new StackTraceElement[] { element });
		when(marker.getAttribute(PICKLED_STACK_TRACE_ATTRIBUTE)).thenReturn(pickledStackTrace);
		when(marker.getAttribute(MESSAGE)).thenReturn("message");
		resolution.run(marker);
		assertEquals(element, getOnlyElement(actualStackTrace));
		assertEquals("message", actualMessage);
	}
}