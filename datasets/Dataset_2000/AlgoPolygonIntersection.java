public class AlgoPolygonIntersection extends AlgoPolygonOperation {
	public AlgoPolygonIntersection(Construction cons, String[] labels,
			GeoPolygon inPoly0, GeoPolygon inPoly1) {
		super(cons, labels, inPoly0, inPoly1, AlgoPolygonOperation.TYPE_INTERSECTION);
	}
	@Override
	public String getClassName() {
		return "AlgoPolygonIntersection";
	}
}