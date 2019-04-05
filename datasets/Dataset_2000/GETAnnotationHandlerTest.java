public class GETAnnotationHandlerTest extends MethodOnlyAnnotationBaseTest<GET> {
    private final GETAnnotationHandler toTest = new GETAnnotationHandler();
    public GETAnnotationHandlerTest() {
        super(GET.class);
    }
    @Test
    public void handleMethodAnnotationShouldSetMethodTypeToGET() throws Exception {
        toTest.handleMethodAnnotation(mockAnnotation, mockMethodConfigBuilder);
        verify(mockMethodConfigBuilder).setType(MethodType.GET);
    }
    @Override
    public AnnotationHandler<GET> getToTest() {
        return toTest;
    }
}