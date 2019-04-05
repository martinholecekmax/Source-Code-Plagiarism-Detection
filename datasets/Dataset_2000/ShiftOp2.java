public class ShiftOp2 extends ShiftOp {
  public ShiftOp2(Token firstToken, Token lastToken) {
    super(new Property[] {
    }, firstToken, lastToken);
  }
  public ShiftOp2(Property[] properties, IToken firstToken, IToken lastToken) {
    super(properties,firstToken,lastToken);
  }
  public IASTNode deepCopy() {
    return new ShiftOp2(cloneProperties(),firstToken,lastToken);
  }
}