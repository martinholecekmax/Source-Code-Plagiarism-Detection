public class RelationalExpressionAST extends ExpressionAST
{
  private ExpressionAST firstExpression;
  private ExpressionAST secondExpression;
  private RelationalExpressionTypeAST type;
  
  public RelationalExpressionAST(ExpressionAST firstExpression, RelationalExpressionTypeAST type, ExpressionAST secondExpression, LexicalPhrase lexicalPhrase)
  {
    super(lexicalPhrase);
    this.firstExpression = firstExpression;
    this.secondExpression = secondExpression;
    this.type = type;
  }
  
  public ExpressionAST getFirstExpression()
  {
    return firstExpression;
  }
  
  public ExpressionAST getSecondExpression()
  {
    return secondExpression;
  }
  
  public RelationalExpressionTypeAST getType()
  {
    return type;
  }
  
  @Override
  public String toString()
  {
    return "" + firstExpression + type.getOperatorString() + secondExpression;
  }
}