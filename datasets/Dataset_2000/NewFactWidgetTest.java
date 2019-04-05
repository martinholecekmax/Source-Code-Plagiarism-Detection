public class NewFactWidgetTest {
    private NewFactWidgetView view;
    private NewFactWidgetView.Presenter presenter;
    private FieldConstraintHelper helper;
    @Before
    public void setUp() throws Exception {
        view = mock(NewFactWidgetView.class);
        helper = mock(FieldConstraintHelper.class);
    }
    private void createNewFactWidget() {
        presenter = new NewFactWidget(helper, view);
    }
    @Test
    public void testSetPresenter() throws Exception {
        createNewFactWidget();
        verify(view).setPresenter(presenter);
    }
    @Test
    public void testSetFactName() throws Exception {
        when(
                helper.resolveFieldType()
        ).thenReturn(
                "Address"
        );
        createNewFactWidget();
        verify(view).setFactName("Address");
    }
    @Test
    public void testAddFieldDataConstraint() throws Exception {
    }
}