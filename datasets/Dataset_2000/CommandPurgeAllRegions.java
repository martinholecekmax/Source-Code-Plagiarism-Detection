public class CommandPurgeAllRegions implements ICommand {
    final static Logger LOG = Logger.getLogger(CommandPurgeAllRegions.class);
    @Override
    public String commandDescription() {
        return "Purge all data from cache: WARNING!";
    }
    @Override
    public String usageDescription() {
        return "<cmd>";
    }
    @Override
    public CommandResult run(ConfigurableApplicationContext mainContext, List<String> parameters) {
        List<String> messages = new ArrayList<String>();
        Map<String, GemfireTemplate> allRegionTemplates = CommandRegionUtils.getAllGemfireTemplates(mainContext);
        for (String key : allRegionTemplates.keySet()) {
            GemfireTemplate oneTemplate = allRegionTemplates.get(key);
                                    removeAllFromRegion(oneTemplate.getRegion());
            messages.add("Region: " + oneTemplate.getRegion().getName() + " contains " + oneTemplate.getRegion().size()
                    + " elements");
        }
        return new CommandResult(null, messages);
    }
    
    private void removeAllFromRegion(Region<?, ?> region) {
        Set regionKeys = region.keySet();
        Object regionKeyArray[] = regionKeys.toArray();
        for (Object oneKey : regionKeyArray) {
            region.remove(oneKey);
        }
    }
    @Override
    public int numberOfParameters() {
        return 0;
    }
}