public class DataServletOutputStream
        extends ServletOutputStream {
    private DataOutputStream stream = null;
    
    public DataServletOutputStream(OutputStream out) {
        stream = new DataOutputStream(out);
    }
    
    @Override
    public void write(int i) throws IOException {
        stream.write(i);
    }
    
    @Override
    public void write(byte[] b) throws IOException {
        stream.write(b);
    }
    
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        stream.write(b, off, len);
    }
}