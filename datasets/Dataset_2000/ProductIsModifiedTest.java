public class ProductIsModifiedTest extends TestCase {
    public ProductIsModifiedTest(String testName) {
        super(testName);
    }
    
    public void testProductConstructors() {
        createProduct();
    }
    private Product createProduct() {
        return new Product("product", "TestProduct", 20, 30);
    }
}