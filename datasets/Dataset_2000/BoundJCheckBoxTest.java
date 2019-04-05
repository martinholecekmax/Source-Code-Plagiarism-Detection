public class BoundJCheckBoxTest extends TestCase {
    final BooleanModel model = new BooleanModel();
    @Bound(to = "state")
    final JCheckBox box = new JCheckBox();
    final Bindings bindings = Bindings.standard();
    @Override
    protected void setUp() throws Exception {
        bindings.bind(this);
    }
    public void testSimple() {
        assertFalse(model.isState());
        assertFalse(box.isSelected());
        model.setState(true);
        assertTrue(box.isSelected());
        assertTrue(model.isState());
        box.doClick();
        assertFalse(model.isState());
        assertFalse(box.isSelected());
    }
}