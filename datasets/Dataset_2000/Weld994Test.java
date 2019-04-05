@RunWith(Arquillian.class)
@Ignore("WELD-994")
public class Weld994Test {
    @Deployment
    public static Archive<?> deploy() {
        return ShrinkWrap.create(BeanArchive.class)
                .addPackage(Weld994Test.class.getPackage());
    }
    @Test
    public void testInjectUnserializableObjectIntoInstanceFieldOfPassivatingBean(PassivatingBean passivatingBean) {
        Instance<UnserializableObject> instance = passivatingBean.getUnserializableObjectInstance();
        instance.get();     }
}