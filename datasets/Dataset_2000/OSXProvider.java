public class OSXProvider extends PasswordProvider {
	static {
		System.loadLibrary("keystoreNative"); 	}
	static final private String serviceName = "equinox.secure.storage"; 	private String accountName = System.getProperty("user.name"); 	private native String getPassword(String service, String account) throws SecurityException;
	private native String setPassword(String serviceName, String accountName, String password) throws SecurityException;
	public PBEKeySpec getPassword(IPreferencesContainer container, int passwordType) {
		if (accountName == null)
			return null;
		boolean newPassword = ((passwordType & CREATE_NEW_PASSWORD) != 0);
		boolean passwordChange = ((passwordType & PASSWORD_CHANGE) != 0);
				if (!newPassword && !passwordChange) {
			try {
				return new PBEKeySpec(getPassword(serviceName, accountName).toCharArray());
			} catch (SecurityException e) {
				AuthPlugin.getDefault().logError(OSXProviderMessages.getPasswordError, e);
				return null;
			}
		}
		try {
			byte[] rawPassword = new byte[64];
			SecureRandom random = new SecureRandom();
			random.setSeed(System.currentTimeMillis());
			random.nextBytes(rawPassword);
			String newPasswordString = Base64.encode(rawPassword);
						if (!newPassword && !passwordChange) {
				try {
					return new PBEKeySpec(getPassword(serviceName, accountName).toCharArray());
				} catch (SecurityException e) {
									}
			}
						setPassword(serviceName, accountName, newPasswordString);
			return new PBEKeySpec(newPasswordString.toCharArray());
		} catch (SecurityException e) {
			AuthPlugin.getDefault().logError(OSXProviderMessages.setPasswordError, e);
			return null;
		}
	}
}