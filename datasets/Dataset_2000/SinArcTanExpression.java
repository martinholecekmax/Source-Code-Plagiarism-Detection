public class SinArcTanExpression implements Expression {
    private String arg1, arg2, arg3;
    SinArcTanExpression(Matcher m){
        arg1 = m.group(1);
        arg2 = m.group(2);
        arg3 = m.group(3);
    }
    public double evaluate(Context ctx){
        double x = ctx.getValue(arg1);
        double y = ctx.getValue(arg2);
        double z = ctx.getValue(arg3);
        return x*Math.sin(Math.atan(z / y));
    }
}