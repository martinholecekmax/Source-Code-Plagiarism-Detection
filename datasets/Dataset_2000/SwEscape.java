public class SwEscape extends SwitchEntryBody {
    final public static int ARG_LENGTH = 1 ;
    final public static int TOK_LENGTH = 3 ;
    public AST_Exp getAST_Exp () {
        return (AST_Exp) arg [0] ;
    }
    public AstToken getCASE_ESCAPE () {
        return (AstToken) tok [0] ;
    }
    public boolean[] printorder () {
        return new boolean[] {true, true, false, true} ;
    }
    public SwEscape setParms
    (AstToken tok0, AstToken tok1, AST_Exp arg0, AstToken tok2) {
        arg = new AstNode [ARG_LENGTH] ;
        tok = new AstTokenInterface [TOK_LENGTH] ;
        tok [0] = tok0 ;            
        tok [1] = tok1 ;            
        arg [0] = arg0 ;            
        tok [2] = tok2 ;            
        InitChildren () ;
        return (SwEscape) this ;
    }
}