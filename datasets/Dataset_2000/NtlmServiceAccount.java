public class NtlmServiceAccount {
	public NtlmServiceAccount(String account, String password) {
		setAccount(account);
		setPassword(password);
	}
	public String getAccount() {
		return _account;
	}
	public String getAccountName() {
		return _accountName;
	}
	public String getComputerName() {
		return _computerName;
	}
	public String getPassword() {
		return _password;
	}
	public void setAccount(String account) {
		_account = account;
		_accountName = _account.substring(0, _account.indexOf(CharPool.AT));
		_computerName = _account.substring(
			0, _account.indexOf(StringPool.DOLLAR));
	}
	public void setPassword(String password) {
		_password = password;
	}
	private String _account;
	private String _accountName;
	private String _computerName;
	private String _password;
}