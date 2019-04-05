public class KeyCacheKey extends Pair<Descriptor, ByteBuffer> implements CacheKey
{
    public KeyCacheKey(Descriptor desc, ByteBuffer key)
    {
        super(desc, key);
    }
    public ByteBuffer serializeForStorage()
    {
        ByteBuffer bytes = ByteBuffer.allocate(serializedSize());
        bytes.put(right.slice());
        bytes.rewind();
        return bytes;
    }
    public Pair<String, String> getPathInfo()
    {
        return new Pair<String, String>(left.ksname, left.cfname);
    }
    public int serializedSize()
    {
        return right.remaining();
    }
    public String toString()
    {
        return String.format("KeyCacheKey(descriptor:%s, key:%s)", left, right);
    }
}