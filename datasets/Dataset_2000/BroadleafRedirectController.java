public class BroadleafRedirectController {
	public String redirect(HttpServletRequest request, HttpServletResponse response, Model model) {
		String path = (String) request.getSession().getAttribute("BLC_REDIRECT_URL");
		if (path == null) {
			path = request.getContextPath();
		}
		return "ajaxredirect:" + path;
	}
}