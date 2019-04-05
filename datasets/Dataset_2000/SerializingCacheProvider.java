public class SerializingCacheProvider implements IRowCacheProvider
{
    public ICache<RowCacheKey, IRowCacheEntry> create(int capacity, boolean useMemoryWeigher)
    {
        return new SerializingCache<RowCacheKey, IRowCacheEntry>(capacity, useMemoryWeigher, new RowCacheSerializer());
    }
    private static class RowCacheSerializer implements ISerializer<IRowCacheEntry>
    {
        public void serialize(IRowCacheEntry cf, DataOutput out)
        {
            assert cf != null;             try
            {
                out.writeBoolean(cf instanceof RowCacheSentinel);
                if (cf instanceof RowCacheSentinel)
                    out.writeLong(((RowCacheSentinel) cf).sentinelId);
                else
                    ColumnFamily.serializer.serialize((ColumnFamily) cf, out);
            }
            catch (IOException e)
            {
                throw new IOError(e);
            }
        }
        public IRowCacheEntry deserialize(DataInput in) throws IOException
        {
            boolean isSentinel = in.readBoolean();
            if (isSentinel)
                return new RowCacheSentinel(in.readLong());
            return ColumnFamily.serializer.deserialize(in);
        }
        public long serializedSize(IRowCacheEntry cf)
        {
            return DBConstants.boolSize
                   + (cf instanceof RowCacheSentinel
                      ? DBConstants.intSize + DBConstants.longSize
                      : ColumnFamily.serializer().serializedSize((ColumnFamily) cf));
        }
    }
}