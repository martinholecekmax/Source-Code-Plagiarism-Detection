public class ComboViewerTest extends StructuredViewerTest {
    public ComboViewerTest(String name) {
        super(name);
    }
    protected StructuredViewer createViewer(Composite parent) {
        ComboViewer viewer = new ComboViewer(parent);
        viewer.setContentProvider(new TestModelContentProvider());
        return viewer;
    }
    protected int getItemCount() {
        TestElement first = fRootElement.getFirstChild();
        Combo list = (Combo) fViewer.testFindItem(first);
        return list.getItemCount();
    }
    protected String getItemText(int at) {
        Combo list = (Combo) fViewer.getControl();
        return list.getItem(at);
    }
    public static void main(String args[]) {
        junit.textui.TestRunner.run(ComboViewerTest.class);
    }
    
    public void testInsertChild() {
    }
}