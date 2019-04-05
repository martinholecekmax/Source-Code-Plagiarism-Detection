public class SourceLinesOfCodeModuleMetric extends ModuleMetric {
    public String getDisplayName() {
        return StockMetricsBundle.message("source.lines.of.code.display.name");
    }
    public String getAbbreviation() {
        return StockMetricsBundle.message("source.lines.of.code.abbreviation");
    }
    public MetricType getType() {
        return MetricType.Count;
    }
}