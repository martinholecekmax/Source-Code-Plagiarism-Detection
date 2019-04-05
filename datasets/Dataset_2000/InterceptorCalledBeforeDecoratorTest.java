@SpecVersion(spec = "cdi", version = "20091101")
public class InterceptorCalledBeforeDecoratorTest extends AbstractTest {
    @Deployment
    public static WebArchive createTestArchive() {
        return new WebArchiveBuilder().withTestClassPackage(InterceptorCalledBeforeDecoratorTest.class)
                .withBeansXml("beans.xml").build();
    }
    @Test
    @SpecAssertions({ @SpecAssertion(section = "9.4", id = "g"), @SpecAssertion(section = "9.2", id = "b") })
    public void testInterceptorCalledBeforeDecorator() {
        FooImpl.interceptorCalledFirst = false;
        FooImpl.decoratorCalledFirst = false;
        Foo foo = getInstanceByType(Foo.class);
        foo.bar();
        assert FooImpl.interceptorCalledFirst;
        assert !FooImpl.decoratorCalledFirst;
    }
}