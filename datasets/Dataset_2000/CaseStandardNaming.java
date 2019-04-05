public abstract class CaseStandardNaming<T> extends Case<T> {
    @XmlElement(required = false, name = "product")
    @XmlIDREF
    private DefaultProduct product;
    @XmlElement(required = false, name = "productCategory")
    private ProductCategory productCategory;
    @XmlElement(required = false, name = "billingPeriod")
    private BillingPeriod billingPeriod;
    @XmlElement(required = false, name = "priceList")
    @XmlIDREF
    private DefaultPriceList priceList;
    public DefaultProduct getProduct() {
        return product;
    }
    public ProductCategory getProductCategory() {
        return productCategory;
    }
    public BillingPeriod getBillingPeriod() {
        return billingPeriod;
    }
    public DefaultPriceList getPriceList() {
        return priceList;
    }
    protected CaseStandardNaming<T> setProduct(final DefaultProduct product) {
        this.product = product;
        return this;
    }
    protected CaseStandardNaming<T> setProductCategory(final ProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }
    protected CaseStandardNaming<T> setBillingPeriod(final BillingPeriod billingPeriod) {
        this.billingPeriod = billingPeriod;
        return this;
    }
    protected CaseStandardNaming<T> setPriceList(final DefaultPriceList priceList) {
        this.priceList = priceList;
        return this;
    }
}