public class GenePropHeadersStorage implements Storage {
    private final static String PREFIX = "geneproperty.";
    private final static String PREFIX_CURATED = "curatedname.";
    private final static String PREFIX_API = "apiname.";
    private final static String PREFIX_LINK = "link.";
    private AtlasGenePropertyService genePropService;
    public void setGenePropService(AtlasGenePropertyService genePropService) {
        this.genePropService = genePropService;
    }
    public void setProperty(String name, String value) {
            }
    public String getProperty(String name) {
        if(!name.startsWith(PREFIX))
            return null;
        String what = name.substring(PREFIX.length());
        if(what.startsWith(PREFIX_CURATED))
            return StringUtil.upcaseFirst(what.substring(PREFIX_CURATED.length()));
        if(what.startsWith(PREFIX_LINK))
            return "";
        if(what.startsWith(PREFIX_API)) {
            String property = what.substring(PREFIX_API.length()).toLowerCase();
            return property.endsWith("s") ? property : property + "s";
        }
        return null;
    }
    public boolean isWritePersistent() {
        return false;
    }
    public Collection<String> getAvailablePropertyNames() {
        List<String> result = new ArrayList<String>();
        for(String v : genePropService.getAllProperties()) {
            result.add(PREFIX + PREFIX_API + v);
            result.add(PREFIX + PREFIX_LINK + v);
            result.add(PREFIX + PREFIX_CURATED + v);
        }
        return result;
    }
    public void reload() {
            }
}