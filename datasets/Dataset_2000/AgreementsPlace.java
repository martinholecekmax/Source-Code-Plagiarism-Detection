public class AgreementsPlace extends LoggedInPlace implements HeadingPlace, WindowTitlePlace {
	public static PageMapping Agreements = new PageMapping(new AgreementsPlace.Tokenizer(), "agreements");
	public static class Tokenizer implements PlaceTokenizer<AgreementsPlace> {
		@Override
		public AgreementsPlace getPlace(String token) {
			return AgreementsPlace.createPlace(ProjectsDiscoverPlace.createPlace());
		}
		@Override
		public String getToken(AgreementsPlace place) {
			return place.getToken();
		}
	}
	public static AgreementsPlace createPlace(DefaultPlace postAgreementsPlace) {
		return new AgreementsPlace(postAgreementsPlace);
	}
	private List<Agreement> agreements;
	private DefaultPlace postAgreementsPlace;
	private AgreementsPlace(DefaultPlace postAgreementsPlace) {
		if (postAgreementsPlace == null) {
			this.postAgreementsPlace = ProjectsDiscoverPlace.createPlace();
		} else {
			this.postAgreementsPlace = postAgreementsPlace;
		}
	}
	public DefaultPlace getPostAgreementsPlace() {
		return postAgreementsPlace;
	}
	@Override
	public String getHeading() {
		return "Legal Agreements";
	}
	public List<Agreement> getAgreements() {
		return agreements;
	}
	@Override
	public String getToken() {
		return "";
	}
	@Override
	public String getPrefix() {
		return Agreements.getUrl();
	}
	@Override
	protected void addActions(List<Action<?>> actions) {
		super.addActions(actions);
		actions.add(new GetPendingAgreementsAction());
	}
	@Override
	protected void handleBatchResults() {
		super.handleBatchResults();
		agreements = getResult(GetPendingAgreementsResult.class).get();
		onPlaceDataFetched();
	}
	@Override
	public String getWindowTitle() {
		return WindowTitleBuilder.createWindowTitle("Legal Agreements");
	}
}