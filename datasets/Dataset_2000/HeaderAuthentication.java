public class HeaderAuthentication extends Authentication {
	public void addHeader(AuthenticationParameter ... headers) {
		for (AuthenticationParameter header : headers) {
			super.headers.add(new BasicHeader(header.getName(), header.getValue()));
		}
	}
}