public interface IThrowableProxy {
  String getMessage();
  String getClassName();
  StackTraceElementProxy[] getStackTraceElementProxyArray();
  int getCommonFrames();
  IThrowableProxy getCause();
  IThrowableProxy[] getSuppressed();
}