@Scriptable
public class ExampleTimeSeriesRatingLoader extends AbstractExampleTool {
  
  @SuppressWarnings("unused")
  private static final Logger s_logger = LoggerFactory.getLogger(ExampleTimeSeriesRatingLoader.class);
    
  public static void main(String[] args) {      new ExampleTimeSeriesRatingLoader().initAndRun(args);
    System.exit(0);
  }
    @Override
  protected void doRun() {
    ConfigMaster configMaster = getToolContext().getConfigMaster();
    ConfigDocument<HistoricalTimeSeriesRating> configDoc = new ConfigDocument<HistoricalTimeSeriesRating>(HistoricalTimeSeriesRating.class);
    List<HistoricalTimeSeriesRatingRule> rules = new ArrayList<HistoricalTimeSeriesRatingRule>();
    rules.add(new HistoricalTimeSeriesRatingRule(DATA_SOURCE_NAME, "BLOOMBERG", 1));
    rules.add(new HistoricalTimeSeriesRatingRule(DATA_SOURCE_NAME, SimulatedHistoricalDataGenerator.OG_DATA_SOURCE, 2));
    rules.add(new HistoricalTimeSeriesRatingRule(DATA_PROVIDER_NAME, "CMPL", 1));
    rules.add(new HistoricalTimeSeriesRatingRule(DATA_PROVIDER_NAME, SimulatedHistoricalDataGenerator.OG_DATA_PROVIDER, 2));
    HistoricalTimeSeriesRating ratingConfig = new HistoricalTimeSeriesRating(rules);
    configDoc.setName(DEFAULT_CONFIG_NAME);
    configDoc.setValue(ratingConfig);
    ConfigMasterUtils.storeByName(configMaster, configDoc);
  }
}