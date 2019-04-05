class ConvertToScientificNotationPredicate implements PsiElementPredicate {
  public boolean satisfiedBy(PsiElement element) {
    if (!(element instanceof PsiLiteralExpression)) {
      return false;
    }
    final PsiLiteralExpression expression = (PsiLiteralExpression)element;
    final PsiType type = expression.getType();
    if (!PsiType.DOUBLE.equals(type) && !PsiType.FLOAT.equals(type)) {
      return false;
    }
    String text = expression.getText();
    if (text == null) {
      return false;
    }
    text = text.toLowerCase();
    if (text.startsWith("-")) {
      text = text.substring(1);
    }
    if (!text.contains(".") && text.startsWith("0")) {
      return false;     }
    return !text.contains("e");
  }
}