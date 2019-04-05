public class SamplesActivityTest extends ActivityInstrumentationTestCase2<SamplesActivity> {
    public SamplesActivityTest() {
        super(SamplesActivity.class.getPackage().getName(), SamplesActivity.class);
    }
    @SmallTest
    public void testPreconditions() throws Exception {
    }
    @SmallTest
    public void testList() throws Exception {
        assertTrue(getActivity().getListAdapter().getCount() >= 4);
    }
}