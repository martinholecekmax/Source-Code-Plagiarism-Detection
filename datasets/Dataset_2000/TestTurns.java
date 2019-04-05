public class TestTurns extends TestCase {
    public void testIntersectionVertex() {
        GeometryFactory gf = new GeometryFactory();
        LineString geometry = gf.createLineString(new Coordinate[] {
                new Coordinate(-0.10, 0),
                new Coordinate(0, 0)
                });
        IntersectionVertex v1 = new IntersectionVertex(null, "v1", -0.10, 0);
        IntersectionVertex v2 = new IntersectionVertex(null, "v2", 0, 0);
        PlainStreetEdge leftEdge = new PlainStreetEdge(v1, v2, geometry, "morx", 10.0, StreetTraversalPermission.ALL, true);
        LineString geometry2 = gf.createLineString(new Coordinate[] {
                new Coordinate(0, 0),
                new Coordinate(-0.10, 0)
                });
        PlainStreetEdge rightEdge = new PlainStreetEdge(v1, v2, geometry2, "fleem", 10.0, StreetTraversalPermission.ALL, false);
        assertEquals(180, Math.abs(leftEdge.outAngle - rightEdge.outAngle));
    }
}