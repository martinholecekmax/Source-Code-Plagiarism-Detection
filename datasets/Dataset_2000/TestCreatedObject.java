public class TestCreatedObject
{
    public void testMethodWithServletParameters(HttpServletRequest request, HttpServletResponse response, ServletConfig config, ServletContext context, HttpSession session)
    {
        Object ignore = request;
        ignore = response;
        ignore = config;
        ignore = context;
        ignore = session;
        session = (HttpSession) ignore;
    }
    public Set<Integer> testBeanSetParam(Set<Integer> param)
    {
        return param;
    }
    
    public void namespace()
    {
            }
}