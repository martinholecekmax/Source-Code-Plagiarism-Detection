@Stateless
public class TimerGetCallerPrincipleBean implements TimedObject {
    private static final CountDownLatch latch = new CountDownLatch(1);
    private static final int TIMER_TIMEOUT_TIME_MS = 100;
    private static final int TIMER_CALL_WAITING_S = 2;
    private static volatile String principle = null;
    @Resource
    private TimerService timerService;
    @Resource
    private EJBContext ejbContext;
    public void createTimer() {
        timerService.createTimer(TIMER_TIMEOUT_TIME_MS, null);
    }
    public static String awaitTimerCall() {
        try {
            latch.await(TIMER_CALL_WAITING_S, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return principle;
    }
    @Override
    public void ejbTimeout(final Timer timer) {
        principle = ejbContext.getCallerPrincipal().getName();
        latch.countDown();
    }
}