public class CityUtil {
	public static City initCity(String idioma) {
		String lang="eus";
		if(idioma.equals("es"))lang="cas";
		String serviceURL = composeServiceURL(lang);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(serviceURL);
		try {
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(response.getEntity());
				List<Parking> parkings = getParkingsFromJson(result);
				return new City(DParkingConstants.DPARKING_CITY_NAME, parkings);
			} else {
				Log.e(TAG, "Not successful getting data");
				return null;
			}
		} catch (Exception e) {
			Log.e(TAG, "Error requesting data", e);
			return null;
		}
	}
	private static String composeServiceURL(String idioma) {
		return "http:				+ DParkingConstants.PARAM_IDIOMA + "=" + idioma;
	}
	private static List<Parking> getParkingsFromJson(String json){
		GsonBuilder gsonBuilder = new GsonBuilder();
		Type collectionType = new TypeToken<Collection<Parking>>() {
		}.getType();
		return gsonBuilder.create().fromJson(json,
				collectionType);
	}
	private static String TAG = "CityUtils";
}