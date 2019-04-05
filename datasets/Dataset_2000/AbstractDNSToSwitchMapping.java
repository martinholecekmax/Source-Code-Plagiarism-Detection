@InterfaceAudience.Public
@InterfaceStability.Evolving
public abstract class AbstractDNSToSwitchMapping
    implements DNSToSwitchMapping, Configurable {
  private Configuration conf;
  
  protected AbstractDNSToSwitchMapping() {
  }
  
  protected AbstractDNSToSwitchMapping(Configuration conf) {
    this.conf = conf;
  }
  @Override
  public Configuration getConf() {
    return conf;
  }
  @Override
  public void setConf(Configuration conf) {
    this.conf = conf;
  }
  
  public boolean isSingleSwitch() {
    return false;
  }
  
  public Map<String, String> getSwitchMap() {
    return null;
  }
  
  public String dumpTopology() {
    Map<String, String> rack = getSwitchMap();
    StringBuilder builder = new StringBuilder();
    builder.append("Mapping: ").append(toString()).append("\n");
    if (rack != null) {
      builder.append("Map:\n");
      Set<String> switches = new HashSet<String>();
      for (Map.Entry<String, String> entry : rack.entrySet()) {
        builder.append("  ")
            .append(entry.getKey())
            .append(" -> ")
            .append(entry.getValue())
            .append("\n");
        switches.add(entry.getValue());
      }
      builder.append("Nodes: ").append(rack.size()).append("\n");
      builder.append("Switches: ").append(switches.size()).append("\n");
    } else {
      builder.append("No topology information");
    }
    return builder.toString();
  }
  protected boolean isSingleSwitchByScriptPolicy() {
    return conf != null
        && conf.get(CommonConfigurationKeys.NET_TOPOLOGY_SCRIPT_FILE_NAME_KEY) == null;
  }
  
  public static boolean isMappingSingleSwitch(DNSToSwitchMapping mapping) {
    return mapping != null && mapping instanceof AbstractDNSToSwitchMapping
        && ((AbstractDNSToSwitchMapping) mapping).isSingleSwitch();
  }
}