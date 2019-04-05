public class SubHandlerLineString extends SubHandler {
    
    private ArrayList coordinateList = new ArrayList();
    
    public SubHandlerLineString() {
    }
    
    public void addCoordinate(Coordinate coordinate) {
        coordinateList.add(coordinate);
    }
    
    public boolean isComplete(String message) {
        if (coordinateList.size() > 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public Geometry create(GeometryFactory geometryFactory) {
        Coordinate[] coords = (Coordinate[]) coordinateList.toArray(new Coordinate[ coordinateList.size()]);
        LineString lineString = geometryFactory.createLineString(coords);
        lineString.setUserData( getSRS() );
        lineString.setSRID( getSRID() );
        return lineString;
    }
}