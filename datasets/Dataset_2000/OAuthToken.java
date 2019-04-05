public class OAuthToken {
	private String token;
	private String secret;
    public static final OAuthToken EMPTY_TOKEN = new OAuthToken("Empty token", null);
	public OAuthToken(String token, String secret) {
		super();
		this.token = token;
		this.secret = secret;
	}
	public String getToken() {
		return token;
	}
	public String getSecret() {
		return secret;
	}
	public Token createToken() {
		return new Token(token, secret);
	}
	public static OAuthToken createFromToken(Token token) {
		return new OAuthToken(token.getToken(), token.getSecret());
	}
}