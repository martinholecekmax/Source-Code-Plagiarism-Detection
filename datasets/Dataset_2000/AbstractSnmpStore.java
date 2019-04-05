public abstract class AbstractSnmpStore {
    private final Map<String, SnmpValue> m_responseMap = new TreeMap<String, SnmpValue>();
    public static final String IFINDEX = "ifIndex";
    public abstract void storeResult(SnmpResult res);
    public AbstractSnmpStore() {
    }
    public Integer getInt32(String key) {
        SnmpValue val = getValue(key);
        return (val == null ? null : Integer.valueOf(val.toInt()));
    }
    public Long getUInt32(String key) {
        SnmpValue val = getValue(key);
        return (val == null ? null : Long.valueOf(val.toLong()));
    }
    public String getDisplayString(String key) {
        SnmpValue val = getValue(key);
        return (val == null ? null : val.toDisplayString());
    }
    public String getHexString(String key) {
        SnmpValue val = getValue(key);
        return (val == null ? null : val.toHexString());
    }
    public InetAddress getIPAddress(String key) {
        SnmpValue val = getValue(key);
        return (val == null ? null : val.toInetAddress());
    }
    public String getObjectID(String key) {
        return (getValue(key) == null ? null : getValue(key).toString());
    }
    public SnmpValue getValue(String key) {
        return m_responseMap.get(key);
    }
    protected void putValue(String key, SnmpValue value) {
        m_responseMap.put(key, value);
    }
    public Integer getIfIndex() {
        return getInt32(IFINDEX);
    }
    protected void putIfIndex(int ifIndex) {
        putValue(IFINDEX, SnmpUtils.getValueFactory().getInt32(ifIndex));
    }
    public int size() {
        return m_responseMap.size();
    }
    public boolean isEmpty() {
        return m_responseMap.isEmpty();
    }
}