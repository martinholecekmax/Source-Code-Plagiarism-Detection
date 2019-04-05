public class MockInternationalPrice extends DefaultInternationalPrice {
    public static MockInternationalPrice create0USD() {
        return new MockInternationalPrice(new DefaultPrice().setCurrency(Currency.USD).setValue(BigDecimal.ZERO));
    }
    public static MockInternationalPrice create1USD() {
        return new MockInternationalPrice(new DefaultPrice().setCurrency(Currency.USD).setValue(BigDecimal.ONE));
    }
    public static MockInternationalPrice createUSD(final String value) {
        return new MockInternationalPrice(new DefaultPrice().setCurrency(Currency.USD).setValue(new BigDecimal(value)));
    }
    public MockInternationalPrice(final DefaultPrice... price) {
        setPrices(price);
    }
}