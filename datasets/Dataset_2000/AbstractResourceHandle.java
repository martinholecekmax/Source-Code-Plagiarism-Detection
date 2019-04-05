public abstract class AbstractResourceHandle implements ResourceHandle {
    public byte[] getBytes() throws IOException {
        InputStream in = getInputStream();
        try {
            byte[] bytes = IoUtil.getBytes(in);
            return bytes;
        } finally {
            IoUtil.close(in);
        }
    }
    public Manifest getManifest() throws IOException {
        return null;
    }
    public Certificate[] getCertificates() {
        return null;
    }
    public Attributes getAttributes() throws IOException {
        Manifest m = getManifest();
        if (m == null) {
            return null;
        }
        String entry = getUrl().getFile();
        return m.getAttributes(entry);
    }
    public void close() {
    }
    public String toString() {
        return "[" + getName() + ": " + getUrl() + "; code source: " + getCodeSourceUrl() + "]";
    }
}