public class SlurpBackwardsTest extends EditorActionTestCase {
  @Override
  protected String getActionId() {
    return SlurpBackwardsAction.class.getName();
  }
  @Test
  public void testAction() throws Exception {
    doTextTest("SlurpBackwards.clj", "(a b (<caret>c d) e)", "(a (b c d) e)", true);
  }
}