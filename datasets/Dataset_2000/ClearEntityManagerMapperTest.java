public class ClearEntityManagerMapperTest
{
    
    private final Mockery context = new JUnit4Mockery()
    {
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };
    
    private ClearEntityManagerMapper sut;
    
    private EntityManager em = context.mock(EntityManager.class);
    
    @Before
    public void setup()
    {
        sut = new ClearEntityManagerMapper();
        sut.setEntityManager(em);
    }
    
    @Test
    public void testExecute()
    {
        context.checking(new Expectations()
        {
            {
                oneOf(em).clear();
            }
        });
        sut.execute(null);
        context.assertIsSatisfied();
    }
}