public class MessageFormatService {
	private PostFormatters formatters;
		public PostFormatters getFormatters() {
		return formatters;
	}
	public void setFormatters(PostFormatters formatters) {
		this.formatters = formatters;
	}
		
	public String format(String text,PostOptions options){
		for (Formatter formatter : formatters) {
			text = formatter.format(text, options);
		}
		return text;
	}
}