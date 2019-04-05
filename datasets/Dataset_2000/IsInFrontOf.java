public class IsInFrontOf extends IsInSpatialRelationTo {
	private static Class[] s_supportedCoercionClasses = {IsBehind.class, IsAbove.class, IsBelow.class, IsLeftOf.class, IsRightOf.class};
	@Override
	public Class[] getSupportedCoercionClasses() {
		return s_supportedCoercionClasses;
	}
	@Override
	protected SpatialRelation getSpatialRelation() {
		return SpatialRelation.IN_FRONT_OF;
	}
}