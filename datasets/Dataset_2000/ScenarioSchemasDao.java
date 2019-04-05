public interface ScenarioSchemasDao extends GenericDao<ScenarioSchemas, Integer> {
  public List<ScenarioSchemas> getSchemaNames();
  public List<ScenarioSchemas> getSchemaDescriptions();
  public int getNextSchemaId();
}