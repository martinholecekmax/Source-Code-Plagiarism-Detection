public class UserFinancialInfoResponse {
	private String userName;
	private long balance;
	public UserFinancialInfoResponse() {
	}
	public UserFinancialInfoResponse(String userName, long balance) {
		super();
		this.userName = userName;
		this.balance = balance;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
}