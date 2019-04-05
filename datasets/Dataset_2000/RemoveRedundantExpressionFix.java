public class RemoveRedundantExpressionFix implements LocalQuickFix {
    @NotNull
    @Override
    public String getName() {
        return "Remove redundant expression";
    }
    @NotNull
    @Override
    public String getFamilyName() {
        return "Constant";
    }
    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
        PsiElement element = descriptor.getStartElement();
        Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
        if (editor == null) {
            return;
        }
        if (!(element instanceof GoConstDeclaration)) {
            return;
        }
        GoConstDeclaration cd = (GoConstDeclaration) element;
        GoLiteralIdentifier[] ids = cd.getIdentifiers();
        GoExpr[] expressions = cd.getExpressions();
        if (ids.length == 0) {
            DeleteStmtFix.deleteStatement(cd);
            return;
        }
        if (expressions.length <= ids.length) {
            return;
        }
        cd.deleteChildRange(expressions[ids.length - 1].getNextSibling(), expressions[expressions.length - 1]);
    }
}