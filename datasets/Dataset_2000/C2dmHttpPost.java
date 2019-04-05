class C2dmHttpPost extends HttpPost {
	private static final String REGISTRATION_ID = "registration_id";
	private static final String COLLAPSE_ID = "collapse_key";
	private static final String DELAY_WHILE_IDLE = "delay_while_idle";
	private static final String DATA_KEY_PREFIX = "data.";
	
	public C2dmHttpPost(Message message, AuthToken token, URI uri) {
		super(uri);
		initAuthToken(token);
		initPostEntity(message);
	}
	private void initAuthToken(AuthToken token) {
		this.setHeader("Authorization",
				String.format("GoogleLogin auth=%s", token));
	}
	private void initPostEntity(Message message) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		addParam(params, REGISTRATION_ID, message.getRegistrationId());
		addParam(params, COLLAPSE_ID, message.getCollapseKey());
		if (message.delayWhileIdle())
			addParam(params, DELAY_WHILE_IDLE);
		Map<String, String> data = message.getData();
		for (String key : data.keySet()) {
			addParam(params, DATA_KEY_PREFIX + key, data.get(key));
		}
		try {
			this.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	private static void addParam(List<NameValuePair> params, String key,
			String value) {
		params.add(new BasicNameValuePair(key, value));
	}
	private static void addParam(List<NameValuePair> params, String key) {
		params.add(new BasicNameValuePair(key, null));
	}
}