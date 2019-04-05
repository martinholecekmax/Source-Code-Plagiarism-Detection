public class WebAuthCredential extends Credential {
    protected String username;
    protected String password;
    public WebAuthCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void authorize(HttpRequestBase request) throws Exception {
        request.addHeader("Authorization", "Basic " + new String(Base64.encodeBase64(new String(this.username + ":" + this.password).getBytes())));
    }
}