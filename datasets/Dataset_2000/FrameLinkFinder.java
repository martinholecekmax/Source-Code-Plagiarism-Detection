public class FrameLinkFinder implements LinksFinder {
	private final String content;
	public FrameLinkFinder(final String content) {
		if (content == null || "".equals(content.trim())) {
			throw new IllegalArgumentException("content cannot be null");
		}
		this.content = content;
	}
	public List<String> getLinks() {
		Pattern pattern = Pattern.compile("(?i)(?s)<\\s*?frame.*?src=\"(.*?)\".*?>");
		Matcher matcher = pattern.matcher(content);
		List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list;
	}
}