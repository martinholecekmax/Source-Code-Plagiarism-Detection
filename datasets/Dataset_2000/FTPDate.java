public class FTPDate {
				protected final static long SIX_MONTHS = 183L * 24L * 60L * 60L * 1000L;
		protected final static String[] _months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
			"Dec" };
		protected final static SimpleDateFormat _mlstFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	protected final static SimpleDateFormat _mlstFormatLong = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
	
	static {
				_mlstFormat.setTimeZone( TimeZone.getTimeZone( "UTC"));
		_mlstFormatLong.setTimeZone( TimeZone.getTimeZone( "UTC"));
	}
	
	public final static void packUnixDate(StringBuffer buf, Date dt) {
				if ( dt == null) {
			buf.append("------------");
			return;
		}
				long timeVal = dt.getTime();
		if ( timeVal < 0) {
			buf.append("------------");
			return;
		}
				Calendar cal = new GregorianCalendar( TimeZone.getTimeZone( "UTC"));
		cal.setTime(dt);
		buf.append(_months[cal.get(Calendar.MONTH)]);
		buf.append(" ");
		int dayOfMonth = cal.get(Calendar.DATE);
		if ( dayOfMonth < 10)
			buf.append(" ");
		buf.append(dayOfMonth);
		buf.append(" ");
				long timeNow = System.currentTimeMillis();
		if ( Math.abs(timeNow - timeVal) > SIX_MONTHS) {
						buf.append(" ");
			buf.append(cal.get(Calendar.YEAR));
		}
		else {
						int hr = cal.get(Calendar.HOUR_OF_DAY);
			if ( hr < 10)
				buf.append("0");
			buf.append(hr);
			buf.append(":");
			int mins = cal.get(Calendar.MINUTE);
			if ( mins < 10)
				buf.append("0");
			buf.append(mins);
		}
	}
	
	public final static String packMlstDateTime(long dateTime) {
		return _mlstFormat.format(new Date(dateTime));
	}
	
	public final static String packMlstDateTimeLong(long dateTime) {
		return _mlstFormatLong.format(new Date(dateTime));
	}
}