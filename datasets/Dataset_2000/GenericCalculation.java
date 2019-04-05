public abstract class GenericCalculation extends DelegateStmt<GenericCalculation> {
    private final Operator operator;
    protected GenericCalculation(final ExpressionType type,
                                 final GenericValue arg0,
                                 final Operator operator,
                                 final GenericValue arg1) {
        super(type, arg0, arg1);
        this.operator = operator;
    }
    protected Operator getOperator() {
        return this.operator;
    }
    public String asString() {
        if (this.getOperator() == Operator.NEGATIVE)
            return "-" + this.getExprArg(0).asString();
        else
            return this.getExprArg(0).asString() + " " + this.getOperator() + " " + this.getExprArg(1).asString();
    }
}