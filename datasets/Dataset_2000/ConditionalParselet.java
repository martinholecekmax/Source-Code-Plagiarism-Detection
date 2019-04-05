public class ConditionalParselet implements InfixParselet {
  public Expression parse(Parser parser, Expression left, Token token) {
    Expression thenArm = parser.parseExpression();
    parser.consume(TokenType.COLON);
    Expression elseArm = parser.parseExpression(Precedence.CONDITIONAL - 1);
    return new ConditionalExpression(left, thenArm, elseArm);
  }
  public int getPrecedence() {
    return Precedence.CONDITIONAL;
  }
}