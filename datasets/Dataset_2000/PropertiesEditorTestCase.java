public class PropertiesEditorTestCase extends PropertyEditorTester<Properties> {
    private Properties testedProperties;
    @Before
    public void initProperties() {
        testedProperties = new Properties();
        testedProperties.setProperty("prop1", "value1");
        testedProperties.setProperty("prop2", "value2");
        testedProperties.setProperty("prop3", "value3");
        testedProperties.setProperty("prop32", "value3");
    }
    @Override
    public String[] getInputData() {
        return new String[] { "prop1=value1\nprop2=value2\nprop3=value3\nprop32=value3\n" };
    }
    @Override
    public Object[] getOutputData() {
                return new Object[] { testedProperties };
    }
    @Override
    public String[] getConvertedToText() {
        return new String[] { testedProperties.toString() };
    }
    @Override
    public Comparator<Properties> getComparator() {
        return null;
    }
    @Override
    public Class getType() {
        return Properties.class;
    }
}