public class ChartGrid {
    protected String chartClass;
    protected String chartStyleName;
    
    public String getChartClass() {
        if (this.chartClass == null) {
            return "major";
        } else {
            return this.chartClass;
        }
    }
    
    public String getChartStyleName() {
        return this.chartStyleName;
    }
    
    public void setChartClass(final String value) {
        this.chartClass = value;
    }
    
    public void setChartStyleName(final String value) {
        this.chartStyleName = value;
    }
}