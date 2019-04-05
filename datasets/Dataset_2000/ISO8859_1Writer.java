public final class ISO8859_1Writer extends EncodingWriter {
  private final static ISO8859_1Writer _writer = new ISO8859_1Writer();
  
  public ISO8859_1Writer()
  {
  }
  
  public String getJavaEncoding()
  {
    return "ISO8859_1";
  }
  
  public EncodingWriter create(String javaEncoding)
  {
    return _writer;
  }
  
  public EncodingWriter create()
  {
    return _writer;
  }
  
  public static EncodingWriter getStaticWriter()
  {
    return _writer;
  }
  
  public void write(OutputStreamWithBuffer os, char ch)
    throws IOException
  {
    os.write(ch);
  }
  
  @Override
  public void write(OutputStreamWithBuffer os,
                    char []cBuf, int cOffset, int cLength)
    throws IOException
  {
    byte []bBuf = os.getBuffer();
    int bOffset = os.getBufferOffset();
    int bEnd = bBuf.length;
        while (cLength > 0) {
      int sublen = bEnd - bOffset;
      if (cLength < sublen)
        sublen = cLength;
      for (int i = sublen - 1; i >= 0; i--) {
        bBuf[bOffset + i] = (byte) cBuf[cOffset + i];
      }
      bOffset += sublen;
      cOffset += sublen;
      cLength -= sublen;
      if (bOffset == bEnd) {
        bBuf = os.nextBuffer(bOffset);
        bOffset = os.getBufferOffset();
        bEnd = bBuf.length;
      }
    }
    os.setBufferOffset(bOffset);
  }
}