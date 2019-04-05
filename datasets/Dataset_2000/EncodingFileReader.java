public class EncodingFileReader extends InputStreamReader {
  private static final String DEFAULT_ENCODING = "UTF-8";
  
  public EncodingFileReader(String fileName) throws UnsupportedEncodingException, FileNotFoundException {
    super(new FileInputStream(fileName), DEFAULT_ENCODING);
  }
  
  public EncodingFileReader(String fileName, String encoding) throws UnsupportedEncodingException, FileNotFoundException {
    super(new FileInputStream(fileName), 
          encoding == null ? DEFAULT_ENCODING: encoding);
  }
  
  public EncodingFileReader(File file) throws  UnsupportedEncodingException, FileNotFoundException {
    super(new FileInputStream(file), DEFAULT_ENCODING);
  }
  
  public EncodingFileReader(File file,String encoding) throws  UnsupportedEncodingException, FileNotFoundException {
    super(new FileInputStream(file), 
          encoding == null ? DEFAULT_ENCODING: encoding);
  }
  
  public EncodingFileReader(FileDescriptor fd) {
    super(new FileInputStream(fd));
  }
}