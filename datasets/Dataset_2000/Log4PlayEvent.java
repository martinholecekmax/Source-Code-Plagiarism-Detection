public class Log4PlayEvent {
	
	public String level;
	
	public String category;
	
	public String thread;
	
	public String message;
	
	public String date;
	
	public Log4PlayEvent(LoggingEvent event) {
				DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance();
				this.category = event.categoryName;
		this.thread = event.getThreadName();
		this.date = dateFormat.format(new Date(event.getTimeStamp()));
		this.message = event.getRenderedMessage();
		this.message = this.message.replaceAll("\u003c", "&lt;").replaceAll("\u003e", "&gt;");
				if (event.getLevel().toInt() == Level.TRACE_INT) {
			this.level = "TRACE";
		}
		if (event.getLevel().toInt() == Level.DEBUG_INT) {
			this.level = "DEBUG";
		}
		if (event.getLevel().toInt() == Level.INFO_INT) {
			this.level = "INFO";
		}
		if (event.getLevel().toInt() == Level.WARN_INT) {
			this.level = "WARN";
		}
		if (event.getLevel().toInt() == Level.ERROR_INT) {
			this.level = "ERROR";
		}
	}
}