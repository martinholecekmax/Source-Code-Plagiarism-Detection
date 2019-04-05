public interface BaseMetricsSource {
  
  void init();
  
  void setGauge(String gaugeName, long value);
  
  void incGauge(String gaugeName, long delta);
  
  void decGauge(String gaugeName, long delta);
  
  void removeGauge(String key);
  
  void incCounters(String counterName, long delta);
  
  void updateHistogram(String name, long value);
  
  void updateQuantile(String name, long value);
  
  void removeCounter(String key);
}