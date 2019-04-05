public abstract class HiTuneRecordProxy<T extends Record> {
    public T record = null;
    public HiTuneRecordProxy(T record){
        this.record = record;
    }
    public T getObject(){
        return record;
    }
    public abstract String[] getFields();
    public abstract void add(String field, String value);
    public abstract String getValue(String field);
    public abstract Long getTime();
    public abstract void setTime(long timestamp);
    public abstract Map<String, String> getCommonFields();
    public abstract T copyCommonFields(T record);
    public abstract String getHost();
    public abstract void setHost(String hostname);
}