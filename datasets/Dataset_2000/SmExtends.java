public class SmExtends extends SmExtendsClause {
    final public static int ARG_LENGTH = 1 ;
    final public static int TOK_LENGTH = 1  ;
    public ExtendsClause getExtendsClause () {
        return (ExtendsClause) arg [0] ;
    }
    public boolean[] printorder () {
        return new boolean[] {false} ;
    }
    public SmExtends setParms (ExtendsClause arg0) {
        arg = new AstNode [ARG_LENGTH] ;
        tok = new AstTokenInterface [TOK_LENGTH] ;
        arg [0] = arg0 ;            
        InitChildren () ;
        return (SmExtends) this ;
    }
}