public class Log4JLogRecord extends LogRecord {
                          
  public Log4JLogRecord() {
  }
        
  public boolean isSevereLevel() {
    boolean isSevere = false;
    if (LogLevel.ERROR.equals(getLevel()) ||
        LogLevel.FATAL.equals(getLevel())) {
      isSevere = true;
    }
    return isSevere;
  }
  
  public void setThrownStackTrace(ThrowableInformation throwableInfo) {
    String[] stackTraceArray = throwableInfo.getThrowableStrRep();
    StringBuffer stackTrace = new StringBuffer();
    String nextLine;
    for (int i = 0; i < stackTraceArray.length; i++) {
      nextLine = stackTraceArray[i] + "\n";
      stackTrace.append(nextLine);
    }
    _thrownStackTrace = stackTrace.toString();
  }
                  }