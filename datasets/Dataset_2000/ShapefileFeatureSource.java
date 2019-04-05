class ShapefileFeatureSource extends AbstractFeatureSource {
    private final ShapefileDataStore shapefile;
    private final SimpleFeatureType featureType;
    ShapefileFeatureSource( ShapefileDataStore shapefileDataStore, Set hints, SimpleFeatureType featureType ) {
        super(hints);
        shapefile = shapefileDataStore;
        this.featureType = featureType;
        this.queryCapabilities = new ShapefileQueryCapabilities();
    }
    public DataStore getDataStore() {
        return shapefile;
    }
    public void addFeatureListener(FeatureListener listener) {
        shapefile.listenerManager.addFeatureListener(this, listener);
    }
    public void removeFeatureListener(FeatureListener listener) {
        shapefile.listenerManager.removeFeatureListener(this, listener);
    }
    public SimpleFeatureType getSchema() {
        return featureType;
    }
    public ReferencedEnvelope getBounds(Query query) throws IOException {
        return shapefile.getBounds(query);
    }
}