public class AddReviewItemAction extends AnAction  implements DumbAware {
  private static final Icon ICON = IconLoader.getIcon("/images/note_edit.png");
    @SuppressWarnings({"UnusedDeclaration"})
    public AddReviewItemAction() {
    }
    public AddReviewItemAction(String title) {
        super(title, title, ICON);
    }
    @Override
    public void actionPerformed(AnActionEvent e) {
        DataContext dataContext = e.getDataContext();
        Project project = PlatformDataKeys.PROJECT.getData(dataContext);
        if (project == null) return;
        Editor editor = PlatformDataKeys.EDITOR.getData(e.getDataContext());
        if(editor != null) {
            final ReviewActionManager instance = ReviewActionManager.getInstance();
            Review review = instance.getReviewForAction(e);
            if(review == null || !review.isValid()) {return;}
            ReviewPoint reviewPoint = ReviewPointManager.getInstance(project).findReviewPoint(review);
            instance.addToExistingComments(editor, reviewPoint);
        }
    }
}