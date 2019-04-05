public class DefaultIndexUpdateMonitor implements IndexUpdateMonitor
{
   private final AtomicBoolean updateInProgress;
   
   private final List<IndexUpdateMonitorListener> listeners;
   
   public DefaultIndexUpdateMonitor()
   {
      super();
      this.updateInProgress = new AtomicBoolean(false);
      this.listeners = new CopyOnWriteArrayList<IndexUpdateMonitorListener>();
   }
   
   public boolean getUpdateInProgress()
   {
      return updateInProgress.get();
   }
   
   public void setUpdateInProgress(boolean updateInProgress, boolean persitentUpdate)
   {
      this.updateInProgress.set(updateInProgress);
      for (IndexUpdateMonitorListener listener : listeners)
      {
         listener.onUpdateInProgressChange(updateInProgress);
      }
   }
   
   public void addIndexUpdateMonitorListener(IndexUpdateMonitorListener listener)
   {
      listeners.add(listener);
   }
   
   public void removeIndexUpdateMonitorListener(IndexUpdateMonitorListener listener)
   {
      listeners.remove(listener);
   }
}