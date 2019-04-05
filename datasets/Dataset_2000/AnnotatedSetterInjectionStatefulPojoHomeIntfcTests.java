public class AnnotatedSetterInjectionStatefulPojoHomeIntfcTests extends AnnotatedSetterInjectionStatefulTestClient {
    public AnnotatedSetterInjectionStatefulPojoHomeIntfcTests() {
        super("AnnotatedSetterInjectionStatefulHomeIntfc.");
    }
    protected void setUp() throws Exception{
        super.setUp();
    }
    @EJB(name="client/tests/stateful/BasicStatefulPojoHome",
   	     beanInterface=BasicStatefulHome.class)
    public void setEjbHome(BasicStatefulHome bsEjbHome) {
    	ejbHome = bsEjbHome;
    }
                public void test01_create(){
        try{
            ejbObject = ejbHome.createObject("BasicStatefulObject");
            assertNotNull( "The EJBObject is null", ejbObject );
        } catch (Exception e){
            fail("Received Exception "+e.getClass()+ " : "+e.getMessage());
        }
    }
            }