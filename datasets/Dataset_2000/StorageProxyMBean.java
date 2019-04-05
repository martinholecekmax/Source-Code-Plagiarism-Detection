public interface StorageProxyMBean
{
    public long getReadOperations();
    public long getTotalReadLatencyMicros();
    public double getRecentReadLatencyMicros();
    public long[] getTotalReadLatencyHistogramMicros();
    public long[] getRecentReadLatencyHistogramMicros();
    public long getRangeOperations();
    public long getTotalRangeLatencyMicros();
    public double getRecentRangeLatencyMicros();
    public long[] getTotalRangeLatencyHistogramMicros();
    public long[] getRecentRangeLatencyHistogramMicros();
    public long getWriteOperations();
    public long getTotalWriteLatencyMicros();
    public double getRecentWriteLatencyMicros();
    public long[] getTotalWriteLatencyHistogramMicros();
    public long[] getRecentWriteLatencyHistogramMicros();
    public long getTotalHints();
    public boolean getHintedHandoffEnabled();
    public void setHintedHandoffEnabled(boolean b);
    public int getMaxHintWindow();
    public void setMaxHintWindow(int ms);
    public int getMaxHintsInProgress();
    public void setMaxHintsInProgress(int qs);
    public int getHintsInProgress();
    public Long getRpcTimeout();
    public void setRpcTimeout(Long timeoutInMillis);
}