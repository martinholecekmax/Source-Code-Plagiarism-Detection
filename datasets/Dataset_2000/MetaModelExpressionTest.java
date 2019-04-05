public class MetaModelExpressionTest extends AbstractTest {
	@Test
	public void testParentExpression(){
		Schema schema = survey.getSchema();
		EntityDefinition clusterDefn = schema.getRootEntityDefinition("cluster");
		NodeDefinition plotDefn = clusterDefn.getChildDefinition("plot");
		SchemaPathExpression expression = new SchemaPathExpression("parent()");
		NodeDefinition resultDefn = expression.evaluate(plotDefn);
		Assert.assertEquals(clusterDefn, resultDefn);
	}
}