public class IfDCTest extends TestCase {
	private static final Logger logger = Logger.getLogger(IfDCTest.class);
	public void setUp() {
		logger.debug("========================== " + getName() + "===================" );
	}
	DesignInstance design;
	public void testCreate() throws ArooaParseException {
		String xml =  
				"<state:if xmlns:state='http:				" name='Test'/>";
    	ArooaDescriptor descriptor = 
    		new OddjobDescriptorFactory().createDescriptor(
    				getClass().getClassLoader());
		DesignParser parser = new DesignParser(
				new StandardArooaSession(descriptor));
		parser.setArooaType(ArooaType.COMPONENT);
		parser.parse(new XMLConfiguration("TEST", xml));
		design = parser.getDesign();
		assertEquals(IfDesign.class, design.getClass());
	}
	public static void main(String args[]) throws ArooaParseException {
		IfDCTest test = new IfDCTest();
		test.testCreate();
		ViewMainHelper view = new ViewMainHelper(test.design);
		view.run();
	}
}