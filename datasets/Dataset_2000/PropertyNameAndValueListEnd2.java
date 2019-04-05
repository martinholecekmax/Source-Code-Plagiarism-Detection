public class PropertyNameAndValueListEnd2 extends PropertyNameAndValueListEnd {
  public PropertyNameAndValueListEnd2(Token firstToken, Token lastToken) {
    super(new Property[] {
    }, firstToken, lastToken);
  }
  public PropertyNameAndValueListEnd2(Property[] properties, IToken firstToken, IToken lastToken) {
    super(properties,firstToken,lastToken);
  }
  public IASTNode deepCopy() {
    return new PropertyNameAndValueListEnd2(cloneProperties(),firstToken,lastToken);
  }
}