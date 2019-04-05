public interface IChangeNotifier
{
  
  void fireNotifyChanged(Notification notification);
  
  void addListener(INotifyChangedListener notifyChangedListener);
  
  void removeListener(INotifyChangedListener notifyChangedListener);
}