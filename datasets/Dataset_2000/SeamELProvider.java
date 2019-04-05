public class SeamELProvider implements ELProvider {
	public ELContext getContext(final ELContext ctx) {
		return new ELContext() {
			private SeamFunctionMapper functionMapper;
			@Override
			public ELResolver getELResolver() {
				return ctx.getELResolver();
			}
			@Override
			public FunctionMapper getFunctionMapper() {
				if (functionMapper == null)
					functionMapper = new SeamFunctionMapper(ctx
							.getFunctionMapper());
				return functionMapper;
			}
			@Override
			public VariableMapper getVariableMapper() {
				return ctx.getVariableMapper();
			}
		};
	}
}