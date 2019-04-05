public interface DataRasterReader
{
    String getDescription();
    String[] getMimeTypes();
    String[] getSuffixes();
    boolean canRead(Object source, AVList params);
    DataRaster[] read(Object source, AVList params) throws java.io.IOException;
    void readMetadata(Object source, AVList params) throws java.io.IOException;
}