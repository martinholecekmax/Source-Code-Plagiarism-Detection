@SuppressWarnings("PMD.SystemPrintln")
public class TransactionHistoryPage extends AbstractPage {
    public final static String TABLE_ID = "trxnhistoryList";
    public final static String VOLUNTARY = "Voluntary";
    public TransactionHistoryPage(Selenium selenium) {
        super(selenium);
        verifyPage("viewsavingstrxnhistory");
    }
    public void verifyTableTypeAfterDeposit(int rowCount) {
        for (int i = 1; i <= rowCount; ++i) {
            String[] type = getType(i).split(" ");
            Assert.assertEquals(type[0], VOLUNTARY);
        }
    }
    public String getType(int row) {
        return selenium.getTable(TABLE_ID + "." + row + ".3");
    }
}