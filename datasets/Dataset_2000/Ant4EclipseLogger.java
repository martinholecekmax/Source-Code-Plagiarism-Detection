public interface Ant4EclipseLogger {
  
  void setContext(Object context);
  
  boolean isDebuggingEnabled();
  
  boolean isTraceingEnabled();
  
  void trace(String msg, Object... args);
  
  void debug(String msg, Object... args);
  
  void info(String msg, Object... args);
  
  void warn(String msg, Object... args);
  
  void error(String msg, Object... args);
}