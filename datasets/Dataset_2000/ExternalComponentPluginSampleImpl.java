public class ExternalComponentPluginSampleImpl {
  private List<ExternalSamplePlugin> plugins ;
  public void register(ExternalSamplePlugin plugin) {
    if(plugins == null) plugins = new ArrayList<ExternalSamplePlugin>() ;
    plugins.add(plugin) ;
  }
  public void dump() {
  }
  public boolean expected() {
    if(plugins.size() == 1 &&
             plugins.get(0).getName().equals("ExternalSamplePlugin") &&
             plugins.get(0).getValue().equals("sampleValue")) return true ;
    return false;
  }
}