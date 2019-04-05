public interface BytesModifiable extends Bytes
{
    void set(int i, byte v);
    void insert(int i, byte v);
    void insert(int i, byte[] vs);
    void insert(int i, Bytes vs);
    void insert(int i, String s);
    void insert(int i, ByteBuffer vs);
    void insert(int i, byte[] vs, int from, int to);
    void insert(int i, Bytes vs, int from, int to);
    void insert(int i, String s, int from, int to);
    void insert(int i, ByteBuffer vs, int c);
    void append(byte v);
    void append(byte[] vs);
    void append(Bytes vs);
    void append(String s);
    void append(ByteBuffer vs);
    void append(byte[] vs, int from, int to);
    void append(Bytes vs, int from, int to);
    void append(String s, int from, int to);
    void append(ByteBuffer vs, int c);
    void prepend(byte v);
    void prepend(byte[] vs);
    void prepend(Bytes vs);
    void prepend(String s);
    void prepend(ByteBuffer vs);
    void prepend(byte[] vs, int from, int to);
    void prepend(Bytes vs, int from, int to);
    void prepend(String s, int from, int to);
    void prepend(ByteBuffer vs, int c);
    
    void remove(byte v);
    void ensureCapacity(int minCapacity);
    void compact();
}