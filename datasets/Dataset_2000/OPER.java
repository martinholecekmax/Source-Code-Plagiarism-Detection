public abstract class OPER extends Exp {
    
    public final int op;
    
    public final int optype;
    public OPER(TreeFactory tf, HCodeElement source,
		int optype, int op, int arity) {
	super(tf, source, arity);
	assert Type.isValid(optype);
		this.op = op; this.optype = optype;
    }
    
    public void accept(TreeVisitor v) { v.visit(this); }
        
    public abstract int type();
    
    public int operandType() { return optype; }
}