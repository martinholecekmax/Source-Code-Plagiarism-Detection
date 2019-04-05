public class TwitterCounter {
	final String apiKey;
	IHttpClient client = new URLConnectionHttpClient();
		
	public IHttpClient getClient() {
		return client;
	}
	public TwitterCounter(String twitterCounterApiKey) {
		this.apiKey = twitterCounterApiKey;
	}
	public TwitterCounterStats getStats(Number twitterUserId) {
		Map<String, String> vars = InternalUtils.asMap(
				"twitter_id", twitterUserId,
				"apikey", apiKey
				);				
		String json = client.getPage("http:		try {
			JSONObject jo = new JSONObject(json);
			return new TwitterCounterStats(jo);
		} catch (JSONException e) {
			throw new TwitterException.Parsing(json, e);
		} catch (ParseException e) {
			throw new TwitterException.Parsing(json, e);
		}		
	}		
}