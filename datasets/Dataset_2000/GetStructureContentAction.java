public class GetStructureContentAction extends Action {
	public ActionForward execute(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {
		try {
			String xml = ParamUtil.getString(request, "xml");
			xml = DDMXMLUtil.formatXML(xml);
			String fileName = "structure.xml";
			byte[] bytes = xml.getBytes();
			ServletResponseUtil.sendFile(
				request, response, fileName, bytes, ContentTypes.TEXT_XML_UTF8);
			return null;
		}
		catch (Exception e) {
			PortalUtil.sendError(e, request, response);
			return null;
		}
	}
}