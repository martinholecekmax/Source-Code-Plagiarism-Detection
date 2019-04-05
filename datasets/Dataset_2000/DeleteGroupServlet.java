public class DeleteGroupServlet extends HttpServlet {
    private static final long serialVersionUID = -2354357068390448288L;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupName = request.getParameter("groupName");
                try {
            GroupFactory.init();
            GroupManager groupFactory = GroupFactory.getInstance();
            groupFactory.deleteGroup(groupName);
        } catch (Throwable e) {
            throw new ServletException("Error deleting group " + groupName, e);
        }
        response.sendRedirect("list.jsp");
    }
}