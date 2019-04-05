public interface Unzipper {
    void unzip() throws IOException;
    void conditionalUnzip() throws IOException;
    File unzipFileInArchive(String fileName) throws IOException, FileNotFoundException;
    ZipEntry[] entries() throws IOException;
}