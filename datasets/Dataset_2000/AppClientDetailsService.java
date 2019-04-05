@Service("clientDetails")
public class AppClientDetailsService implements ClientDetailsService {
	private final AppRepository appRepository;
	@Inject
	public AppClientDetailsService(AppRepository appRepository) {
		this.appRepository = appRepository;
	}
	@Override
	public ClientDetails loadClientByClientId(String appId) throws OAuth2Exception {
		try {
			return clientDetailsFor(appRepository.findAppByApiKey(appId));
		} catch (InvalidApiKeyException e) {
			throw new OAuth2Exception("Invalid OAuth App ID " + appId, e);
		}
	}
	private ClientDetails clientDetailsFor(App app) {
		return new AppClientDetails(app);
	}
	@SuppressWarnings("serial")
	private static class AppClientDetails extends BaseClientDetails {
		public AppClientDetails(App app) {
						super(app.getApiKey(), "greenhouseApi", "read,write", "authorization_code,token,password", "ROLE_CLIENT", app.getCallbackUrl());
			setClientSecret(app.getSecret());
		}
	}
}