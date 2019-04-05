public class XANoExplicitTransactionTests extends AbstractNoExplicitJTATests {
    protected String getCompassConfig() {
        return "/org/compass/core/test/transaction/type/jta/compass.xa.cfg.xml";
    }
}