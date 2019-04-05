public class GaeAuthFilter implements Filter {
  @Override
  public void destroy() {
  }
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    UserService userService = UserServiceFactory.getUserService();
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    if (!userService.isUserLoggedIn()) {
      String redirectUrl = request.getHeader(GaeHelper.REDIRECT_URL_HTTP_HEADER_NAME);
      if (redirectUrl == null || redirectUrl.length() == 0) {
                redirectUrl = "/";
      }
      response.setHeader("login", userService.createLoginURL(redirectUrl));
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }
    filterChain.doFilter(request, response);
  }
  @Override
  public void init(FilterConfig config) {
  }
}