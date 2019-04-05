public class WikiDataProcessor extends DataHandler implements DataProcessor{
	public static final int MAX_JSON_OBJECTS = 1000;
	@Override
	public String[] getUrlMatch() {
		String[] str = {"wiki"};
		return str;
	}
	@Override
	public String[] getDataMatch() {
		String[] str = {"wiki"};
		return str;
	}
	@Override
	public boolean matchesRequiredType(String type) {
		if(type.equals(DataSource.TYPE.WIKIPEDIA.name())){
			return true;
		}
		return false;
	}
	@Override
	public List<Marker> load(String rawData, int taskId, int colour) throws JSONException {
		List<Marker> markers = new ArrayList<Marker>();
		JSONObject root = convertToJSON(rawData);
		JSONArray dataArray = root.getJSONArray("geonames");
		int top = Math.min(MAX_JSON_OBJECTS, dataArray.length());
		for (int i = 0; i < top; i++) {
			JSONObject jo = dataArray.getJSONObject(i);
			Marker ma = null;
			if (jo.has("title") && jo.has("lat") && jo.has("lng")
					&& jo.has("elevation") && jo.has("wikipediaUrl")) {
				Log.v(MixView.TAG, "processing Wikipedia JSON object");
								ma = new POIMarker(
						"",
						HtmlUnescape.unescapeHTML(jo.getString("title"), 0), 
						jo.getDouble("lat"), 
						jo.getDouble("lng"), 
						jo.getDouble("elevation"), 
						"http:						taskId, colour);
				markers.add(ma);
			}
		}
		return markers;
	}
	private JSONObject convertToJSON(String rawData){
		try {
			return new JSONObject(rawData);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}
}