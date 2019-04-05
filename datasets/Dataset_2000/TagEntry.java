public class TagEntry
{
    public static final int entrySize = 12;
  private int signature;
  private int size;
  private int offset;
  private byte[] data;
  public TagEntry(int sig, int offset, int size, byte[] data)
  {
    this.signature = sig;
    this.offset = offset;
    this.size = size;
    this.data = new byte[size];
    System.arraycopy(data, offset, this.data, 0, size);
  }
  public TagEntry(int sig, byte[] data)
  {
    this.signature = sig;
    this.size = data.length;
    this.data = new byte[size];
    System.arraycopy(data, offset, this.data, 0, size);
  }
  public byte[] getData()
  {
    byte[] d = new byte[size];
    System.arraycopy(this.data, 0, d, 0, size);
    return d;
  }
  public String hashKey()
  {
    return tagHashKey(signature);
  }
  public String toString()
  {
    String s = "";
    s = s + (char) ((byte) ((signature >> 24) & 0xFF));
    s = s + (char) ((byte) ((signature >> 16) & 0xFF));
    s = s + (char) ((byte) ((signature >> 8) & 0xFF));
    s = s + (char) ((byte) (signature & 0xFF));
    return s;
  }
  public int getSignature()
  {
    return signature;
  }
  public int getSize()
  {
    return size;
  }
  public int getOffset()
  {
    return offset;
  }
  public void setOffset(int offset)
  {
    this.offset = offset;
  }
  public static String tagHashKey(int sig)
  {
    return "" + sig;
  }
}