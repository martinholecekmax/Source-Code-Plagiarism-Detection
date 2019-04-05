public class JexlValueExpressionEvaluator implements ValueExpressionEvaluator {
    private JexlEngine engine = new JexlEngine();
    
    public Object evaluate(Object context, String expression) {
        Expression jexlExpression = engine.createExpression(expression);
        JexlContext jexlContext = new ObjectContext(engine, context);
        return jexlExpression.evaluate(jexlContext);
    }
}