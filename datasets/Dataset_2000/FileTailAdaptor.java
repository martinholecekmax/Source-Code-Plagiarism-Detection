public class FileTailAdaptor extends TimeEventAdaptor {
  static final Log LOG = LogFactory.getLog(FileTailAdaptor.class);
  public FileTailAdaptor(Agent agent, MonitorItem monitorItem) {
    super(agent, monitorItem);
  }
  @Override
  public TimerTask getTimeTask() {
    return new FileTailTask();
  }
  class FileTailTask extends TimerTask {
    @Override
    public void run() {
      synchronized(monitorItems) {
        long collectTime = System.currentTimeMillis();
                for (MonitorItem eachItem: monitorItems) {
          try {
                      } catch (Exception e) {
            LOG.error(e.getMessage(), e);
          }
        }
              }
    }
  }
}