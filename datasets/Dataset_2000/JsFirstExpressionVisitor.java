public class JsFirstExpressionVisitor extends JsVisitor {
  public static boolean exec(JsExprStmt statement) {
    JsFirstExpressionVisitor visitor = new JsFirstExpressionVisitor();
    JsExpression expression = statement.getExpression();
        if (expression instanceof JsFunction) {
      return false;
    }
    visitor.accept(statement.getExpression());
    return visitor.needsParentheses;
  }
  private boolean needsParentheses = false;
  private JsFirstExpressionVisitor() {
  }
  public boolean visit(JsArrayAccess x, JsContext<JsExpression> ctx) {
    accept(x.getArrayExpr());
    return false;
  }
  public boolean visit(JsArrayLiteral x, JsContext<JsExpression> ctx) {
    return false;
  }
  public boolean visit(JsBinaryOperation x, JsContext<JsExpression> ctx) {
    accept(x.getArg1());
    return false;
  }
  public boolean visit(JsConditional x, JsContext<JsExpression> ctx) {
    accept(x.getTestExpression());
    return false;
  }
  public boolean visit(JsFunction x, JsContext<JsExpression> ctx) {
    needsParentheses = true;
    return false;
  }
  public boolean visit(JsInvocation x, JsContext<JsExpression> ctx) {
    accept(x.getQualifier());
    return false;
  }
  public boolean visit(JsNameRef x, JsContext<JsExpression> ctx) {
    if (!x.isLeaf()) {
      accept(x.getQualifier());
    }
    return false;
  }
  public boolean visit(JsNew x, JsContext<JsExpression> ctx) {
    return false;
  }
  public boolean visit(JsObjectLiteral x, JsContext<JsExpression> ctx) {
    needsParentheses = true;
    return false;
  }
  public boolean visit(JsPostfixOperation x, JsContext<JsExpression> ctx) {
    accept(x.getArg());
    return false;
  }
  public boolean visit(JsPrefixOperation x, JsContext<JsExpression> ctx) {
    return false;
  }
  public boolean visit(JsRegExp x, JsContext<JsExpression> ctx) {
    return false;
  }
}