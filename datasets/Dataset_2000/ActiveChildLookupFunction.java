public class ActiveChildLookupFunction extends ContextFunction {
	private String localVar;
	private String var;
	public ActiveChildLookupFunction(String var, String localVar) {
		this.var = var;
		this.localVar = localVar;
	}
	@Override
	public Object compute(IEclipseContext context) {
		IEclipseContext childContext = context.getActiveChild();
		if (childContext != null) {
			return childContext.get(var);
		}
		return context.get(localVar);
	}
}