public class DistanceToTheRightOf extends SpatialRelationDistanceQuestion {
	private static Class[] s_supportedCoercionClasses = {DistanceToTheLeftOf.class, DistanceAbove.class, DistanceBelow.class, DistanceInFrontOf.class, DistanceBehind.class};
	@Override
	public Class[] getSupportedCoercionClasses() {
		return s_supportedCoercionClasses;
	}
	@Override
	protected SpatialRelation getSpatialRelation() {
		return SpatialRelation.RIGHT_OF;
	}
}