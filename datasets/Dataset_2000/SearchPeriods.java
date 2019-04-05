public enum SearchPeriods {
    
    TWENTYFOURHOURS,
    
    SEVENDAYS,
    
    THIRTYDAYS,
    
    ALLTIME,
    
    ONEYEAR,
    
    SearchPeriods() {
            };
    
    public String toString() {
        String period = "null";
                if (this == TWENTYFOURHOURS) { period = "24"; }
                else if (this == SEVENDAYS) { period = "7"; }
                else if (this == THIRTYDAYS) { period = "30"; }
                else if (this == ALLTIME) { period = "all"; } 
                else if (this == ONEYEAR) { period = "365"; }
        return period;
    }
    
    public Integer toNumber() {
    	Integer period = null;
                if (this == TWENTYFOURHOURS) { period = 24; }
                else if (this == SEVENDAYS) { period = 7; }
                else if (this == THIRTYDAYS) { period = 30; }
                else if (this == ALLTIME) { period = 1095; } 
                else if (this == ONEYEAR) { period = 365; }
        return period;
    }
    
    public Integer toDays() {
    	Integer period = null;
                if (this == TWENTYFOURHOURS) { period = 1; }
                else if (this == SEVENDAYS) { period = 7; }
                else if (this == THIRTYDAYS) { period = 30; }
                else if (this == ALLTIME) { period = 1095; }                  else if (this == ONEYEAR) { period = 365; }
        return period;
    }
    
    public static SearchPeriods getPeriodString(final String period) {
        if (null == period) { return TWENTYFOURHOURS; }
        else if (period.equalsIgnoreCase("24")) { return TWENTYFOURHOURS; }
        else if (period.equalsIgnoreCase("7")) { return SEVENDAYS; }
        else if (period.equalsIgnoreCase("30")) { return THIRTYDAYS; }
        else if (period.equalsIgnoreCase("all")) { return ALLTIME; }
        else if (period.equalsIgnoreCase("365")) { return ONEYEAR; }
        else return TWENTYFOURHOURS;
    }
}