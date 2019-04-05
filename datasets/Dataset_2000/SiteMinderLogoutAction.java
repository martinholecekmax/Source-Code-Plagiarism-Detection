public class SiteMinderLogoutAction extends Action {
	public void run(HttpServletRequest request, HttpServletResponse response) {
		try {
			long companyId = PortalUtil.getCompanyId(request);
			if (!AuthSettingsUtil.isSiteMinderEnabled(companyId)) {
				return;
			}
			String domain = CookieKeys.getDomain(request);
			Cookie smSessionCookie = new Cookie(_SMSESSION, StringPool.BLANK);
			if (Validator.isNotNull(domain)) {
				smSessionCookie.setDomain(domain);
			}
			smSessionCookie.setMaxAge(0);
			smSessionCookie.setPath(StringPool.SLASH);
			Cookie smIdentityCookie = new Cookie(_SMIDENTITY, StringPool.BLANK);
			if (Validator.isNotNull(domain)) {
				smIdentityCookie.setDomain(domain);
			}
			smIdentityCookie.setMaxAge(0);
			smIdentityCookie.setPath(StringPool.SLASH);
			CookieKeys.addCookie(request, response, smSessionCookie);
			CookieKeys.addCookie(request, response, smIdentityCookie);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}
	private static final String _SMSESSION = "SMSESSION";
	private static final String _SMIDENTITY = "SMIDENTITY";
	private static Log _log = LogFactoryUtil.getLog(
		SiteMinderLogoutAction.class);
}