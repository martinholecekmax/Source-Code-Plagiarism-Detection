public class DayOfYearToDate {
    public static void main(String[] args) {
                                                int dayOfYear = 112;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
        System.out.println("Day of year " + dayOfYear + " = "
                + calendar.getTime());
                                                int year = 2004;
        calendar.set(Calendar.YEAR, year);
        System.out.println("Day of year " + dayOfYear + " in year " + year
                + " = " + calendar.getTime());
    }
}