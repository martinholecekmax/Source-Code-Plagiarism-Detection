public class GreekToValueGreekConverter extends Function1D<GreekDataBundle, Map<ValueGreek, Double>> {
  @Override
  public Map<ValueGreek, Double> evaluate(final GreekDataBundle data) {
    Validate.notNull(data, "data");
    final GreekResultCollection greeks = data.getGreekResults();
    final Map<ValueGreek, Double> riskFactors = new HashMap<ValueGreek, Double>();
    final Map<UnderlyingType, Double> underlyingData = data.getUnderlyingData();
    final OptionTradeData tradeData = data.getOptionTradeData();
    for (final Pair<Greek, Double> entry : greeks) {
      final Greek key = entry.getKey();
      final Double value = entry.getValue();
      riskFactors.put(new ValueGreek(key), getValueGreek(key, value, underlyingData, tradeData));
    }
    return riskFactors;
  }
    private Double getValueGreek(final Greek greek, final double greekValue, final Map<UnderlyingType, Double> underlyings, final OptionTradeData tradeData) {
    final Underlying order = greek.getUnderlying();
    return TaylorExpansionMultiplierCalculator.getValue(underlyings, order) * greekValue * tradeData.getNumberOfContracts()
        * tradeData.getPointValue() / TaylorExpansionMultiplierCalculator.getMultiplier(order);
  }
}