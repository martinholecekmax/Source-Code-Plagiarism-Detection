public class MotionParagraphNextAction extends MotionEditorAction {
  public MotionParagraphNextAction() {
    super(new Handler());
  }
  private static class Handler extends MotionEditorActionHandler {
    public int getOffset(Editor editor, DataContext context, int count, int rawCount, Argument argument) {
      return CommandGroups.getInstance().getMotion().moveCaretToNextParagraph(editor, count);
    }
  }
}