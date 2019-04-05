public class TimeDelta  extends EvalFunc<Long> {
    public static enum ERRORS { DateParseError };
    private int deltaUnit;
    private boolean parseDate = false;
    private SimpleDateFormat sdf;
    public TimeDelta() {
        deltaUnit = Calendar.MILLISECOND;
    }
    public TimeDelta(String deltaUnitSr) throws ParseException {
        this(deltaUnitSr, null);
    }
    public TimeDelta(String deltaUnitStr, String dateFormat) throws ParseException {
                        deltaUnit = Integer.parseInt(deltaUnitStr);
        if (dateFormat != null) {
            parseDate = true;
            sdf = new SimpleDateFormat(dateFormat);
        }
    }
    @Override
    public Long exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0) {
            return null;
        }
        long delta = 0;
        if (parseDate) {
            try {
                Date d1 = sdf.parse((String)input.get(0));
                Date d2 = sdf.parse((String)input.get(1));
                delta = DateUtil.getTimeDelta(d1.getTime(), d2.getTime(), deltaUnit);
            } catch (ParseException e) {
                pigLogger.warn(this, "Date parse error", ERRORS.DateParseError);
            }
        } else {
            long t1 = ((Number)input.get(0)).longValue();
            long t2 = ((Number)input.get(1)).longValue();
            delta = DateUtil.getTimeDelta(t1, t2, deltaUnit);
        }
        return delta;
    }
}