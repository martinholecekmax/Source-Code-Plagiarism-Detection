public class QueryHBCIVersionMessageConsumer implements MessageConsumer
{
  
  public boolean autoRegister()
  {
    return false;
  }
  
  public Class[] getExpectedMessageTypes()
  {
    return new Class[]{QueryMessage.class};
  }
  
  public void handleMessage(Message message) throws Exception
  {
    if (Application.inServerMode())
      return;     QueryMessage msg = (QueryMessage) message;
    HBCIVersionDialog d = new HBCIVersionDialog(HBCIVersionDialog.POSITION_CENTER);
    msg.setData(d.open());
  }
}