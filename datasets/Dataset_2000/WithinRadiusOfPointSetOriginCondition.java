public class WithinRadiusOfPointSetOriginCondition implements Condition<long[]> {
	private final PointSet pointSet;
	private final long radius;
	private final long radiusSquared;
	public WithinRadiusOfPointSetOriginCondition(long radius, PointSet pointSet) {
		this.pointSet = pointSet;
		this.radius = radius;
		this.radiusSquared = radius * radius;
	}
	@Override
	public boolean isTrue(long[] val) {
		long[] origin = pointSet.getOrigin();
		long sumSq = 0;
		for (int i = 0; i < val.length; i++) {
			long delta = val[i] - origin[i];
			sumSq += delta * delta;
		}
		return sumSq <= radiusSquared;
	}
	@Override
	public WithinRadiusOfPointSetOriginCondition copy() {
										return new WithinRadiusOfPointSetOriginCondition(radius, pointSet);
	}
}