public class AndroidMarketRatingProvider implements IRatingProvider {
	public void startRating(Context context, Map<String, String> args) throws InsufficientRatingArgumentsException {
		if (!args.containsKey("package")) {
			throw new InsufficientRatingArgumentsException("Missing required argument 'package'");
		}
		context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market:	}
	public String activityNotFoundMessage(Context ctx) {
		return ctx.getString(R.string.apptentive_rating_provider_no_android_market);
	}
}