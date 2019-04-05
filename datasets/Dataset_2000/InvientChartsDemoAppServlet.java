public class InvientChartsDemoAppServlet extends ApplicationServlet {
    @Override
    protected void writeAjaxPageHtmlVaadinScripts(Window window,
            String themeName, Application application, BufferedWriter page,
            String appUrl, String themeUri, String appId,
            HttpServletRequest request) throws ServletException, IOException {
        page.write("<script type=\"text/javascript\">\n");
        page.write("        page.write("document.write(\"<script language='javascript' src='./jquery/jquery-1.7.2.min.js'><\\/script>\");\n");
        page.write("document.write(\"<script language='javascript' src='./js/highcharts.js'><\\/script>\");\n");
        page.write("document.write(\"<script language='javascript' src='./js/modules/exporting.js'><\\/script>\");\n");
        page.write("        super.writeAjaxPageHtmlVaadinScripts(window, themeName, application,
                page, appUrl, themeUri, appId, request);
    }
}