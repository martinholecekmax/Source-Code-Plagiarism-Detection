public class TestTxnSimMain extends TestCase
{
    public void testTiny() throws Exception
    {
        TxnGenMain main = new TxnGenMain(20, 200, "TransactionExample", false);
        main.run();
    }
    public void testSmall() throws Exception
    {
        TxnGenMain main = new TxnGenMain(1000, 3000, "TransactionExample", false);
        main.run();
    }
}