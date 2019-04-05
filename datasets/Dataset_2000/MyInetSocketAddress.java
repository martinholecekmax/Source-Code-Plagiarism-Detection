public class MyInetSocketAddress extends InetSocketAddress implements RawSerializable {
  public static final Serializer<MyInetSocketAddress> serializer = new Serializer<MyInetSocketAddress>(){
    public static final byte IPV4 = 4;
    public static final byte IPV6 = 6;
    public static final int IPV4_BYTES = 4;
    public static final int IPV6_BYTES = 16;
    public MyInetSocketAddress deserialize(InputBuffer b) throws IOException {
      byte version = b.readByte();
      byte[] addr;
      switch(version) {
      case IPV4:
        addr = new byte[IPV4_BYTES];
        break;
      case IPV6:
        addr = new byte[IPV6_BYTES];
        break;      
      default:
        throw new IOException("Incorrect IP version, expecting 4 or 6, got "+version);
      }
      b.read(addr);
      short port = b.readShort();    
      return new MyInetSocketAddress(InetAddress.getByAddress(addr),0xFFFF & port);
    }
    public void serialize(MyInetSocketAddress i, OutputBuffer b)
        throws IOException {
      byte[] addr = i.getAddress().getAddress();
            switch (addr.length) {
      case IPV4_BYTES:
        b.writeByte(IPV4);
        break;
      case IPV6_BYTES:
        b.writeByte(IPV6);
        break;
      default:
        throw new IOException("Incorrect number of bytes for IPaddress, expecting 4 or 16, got "+addr.length);
      }
            b.write(addr,0,addr.length);
      b.writeShort((short)i.getPort());    
    }};
  public MyInetSocketAddress(InetAddress addr, int port) {
    super(addr, port);
  }
  public void serialize(OutputBuffer buf) throws IOException {
    serializer.serialize(this, buf);    
  }
}