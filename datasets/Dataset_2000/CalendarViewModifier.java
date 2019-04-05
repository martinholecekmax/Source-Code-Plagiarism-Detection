public class CalendarViewModifier implements LayoutModifier {
    
    private static final long JANUARY_DATE = 946707779241L;
    private static final long FEBRUARY_DATE = 951033600000L;
    private static final TimeZone TZ = TimeZone.getTimeZone("GMT+00:00");
    private final boolean mJanuary;
    public CalendarViewModifier(boolean january) {
        mJanuary = january;
    }
    @Override
    public void prepare() {
        TimeZone.setDefault(TZ);
    }
    @Override
    public View modifyView(View view) {
        ((CalendarView) view).setDate(mJanuary ? JANUARY_DATE : FEBRUARY_DATE);
        return view;
    }
    public static boolean isMonth(int month) {
        Calendar cal = new GregorianCalendar(TZ);
        return cal.get(Calendar.MONTH) == month;
    }
}