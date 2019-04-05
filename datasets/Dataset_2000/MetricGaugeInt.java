class MetricGaugeInt extends MetricGauge<Integer> {
  final int value;
  MetricGaugeInt(String name, String description, int value) {
    super(name, description);
    this.value = value;
  }
  public Integer value() {
    return value;
  }
  public void visit(MetricsVisitor visitor) {
    visitor.gauge(this, value);
  }
}