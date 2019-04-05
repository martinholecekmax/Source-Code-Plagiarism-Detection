public class LowerFunction
		extends ParameterizedFunctionExpression<String>
		implements Serializable {
	public static final String NAME = "lower";
	public LowerFunction(CriteriaBuilderImpl criteriaBuilder, Expression<String> string) {
		super( criteriaBuilder, String.class, NAME, string );
	}
	@Override
	protected boolean isStandardJpaFunction() {
		return true;
	}
}