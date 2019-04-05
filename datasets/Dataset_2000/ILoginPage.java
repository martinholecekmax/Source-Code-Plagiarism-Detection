public interface ILoginPage extends IDFPage {
	
	void login(String username, String password, boolean remember);
	IDashboardPage validLogin(String uname, String passwd, boolean rememberUsername);
	
	boolean loginFailedErrorMessageDisplayed();
	boolean isPasswordEmpty();
	boolean isUsernameSet(String username);
	boolean isRememberUsernameSet() throws InterruptedException;
	boolean isVignetteDisplayed();
	String getVignetteUrl();
	void navigateTo(String url);
	void fillRegistration(Map<String, String> businessData);
	ISignUpWizardStep1 signup();
	void failedSignUp();
	String getError(String type);
}