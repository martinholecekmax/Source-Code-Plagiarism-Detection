public class ApplicablePatchQuery extends ExpressionMatchQuery<IInstallableUnit> {
	private static final IExpression applicablePatches = ExpressionUtil.parse(			"applicabilityScope.empty || applicabilityScope.exists(rqArr | rqArr.all(rq | $0 ~= rq))"); 	
	public ApplicablePatchQuery(IInstallableUnit iu) {
		super(IInstallableUnitPatch.class, applicablePatches, iu);
	}
}