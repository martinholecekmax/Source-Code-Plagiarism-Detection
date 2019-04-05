public class TestDecoder extends InvocationDecoder
{
    
    public static final String RECEIVER_CODE = "b4b66d24b85d870d04c8da3524c188eb";
    
    public static final int RECEIVED_TEST = 1;
    
    public TestDecoder (TestReceiver receiver)
    {
        this.receiver = receiver;
    }
    @Override
    public String getReceiverCode ()
    {
        return RECEIVER_CODE;
    }
    @Override
    public void dispatchNotification (int methodId, Object[] args)
    {
        switch (methodId) {
        case RECEIVED_TEST:
            ((TestReceiver)receiver).receivedTest(
                ((Integer)args[0]).intValue(), (String)args[1]
            );
            return;
        default:
            super.dispatchNotification(methodId, args);
            return;
        }
    }
}