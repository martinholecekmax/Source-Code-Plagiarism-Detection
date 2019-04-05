@BaselineMode(Mode.CLEAR_DB)
public class PropositionBoServiceTest extends AbstractBoTest {
	private PropositionBoService propositionBoService;
	private KrmsTypeRepositoryService krmsTypeRepository;
	@Before
	public void setup() {
		krmsTypeRepository = new KrmsTypeBoServiceImpl();
		((KrmsTypeBoServiceImpl) krmsTypeRepository).setBusinessObjectService(getBoService());
	}
	@Test
	public void creationTest() {
				KrmsTypeDefinition krmsContextTypeDefinition = KrmsTypeDefinition.Builder.create("KrmsTestContextType", "KRMS").build();
		krmsContextTypeDefinition = krmsTypeRepository.createKrmsType(krmsContextTypeDefinition);
	}
}