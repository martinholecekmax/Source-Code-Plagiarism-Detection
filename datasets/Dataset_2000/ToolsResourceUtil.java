public class ToolsResourceUtil {
	private static Logger log = LoggerFactory.getLogger(ToolsResourceUtil.class);
	public static String getTitle(Resource resource) {
		if (resource == null) {
			return "";
		}
		if (resource.getMediaType() != MediatypeService.XHTML) {
			return resource.getHref();
		}
		String title = findTitleFromXhtml(resource);
		if (title == null) {
			title = "";
		}
		return title;
	}
	
	public static String findTitleFromXhtml(Resource resource) {
		if (resource == null) {
			return "";
		}
		if (resource.getTitle() != null) {
			return resource.getTitle();
		}
		Pattern h_tag = Pattern.compile("^h\\d\\s*", Pattern.CASE_INSENSITIVE);
		String title = null;
		try {
			Reader content = resource.getReader();
			Scanner scanner = new Scanner(content);
			scanner.useDelimiter("<");
			while(scanner.hasNext()) {
				String text = scanner.next();
				int closePos = text.indexOf('>');
				String tag = text.substring(0, closePos);
				if (tag.equalsIgnoreCase("title")
					|| h_tag.matcher(tag).find()) {
					title = text.substring(closePos + 1).trim();
					title = StringEscapeUtils.unescapeHtml(title);
					break;
				}
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		resource.setTitle(title);
		return title;
	}
}