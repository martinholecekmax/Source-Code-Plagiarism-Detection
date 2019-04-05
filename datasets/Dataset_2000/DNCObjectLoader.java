public class DNCObjectLoader implements StreamToGeoObjectConverter<DNCObject> {
    @Override
    public DNCObject readNext(DataInputStream dis) throws IOException {
        return DNCObject.read(dis);
    }
}