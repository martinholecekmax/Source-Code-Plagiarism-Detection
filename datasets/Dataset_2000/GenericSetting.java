public class GenericSetting {
	private String name;
	private String value;
	private ArrayList<GenericSettingAttribute> attributes;
	private ArrayList<GenericSetting> settings;
	
	public GenericSetting() {
			}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public ArrayList<GenericSettingAttribute> getAttributes() {
		return attributes;
	}
	
	public boolean hasAttributes(){
		return (attributes == null || attributes.isEmpty()) ? false : true;
	}
	
	public void addAttribute(GenericSettingAttribute attribute){
		if (attributes == null){
			attributes = new ArrayList<GenericSettingAttribute>();
		}
		attributes.add(attribute);
	}
	
	public ArrayList<GenericSetting> getSettings() {
		return settings;
	}
	
	public boolean hasSettings(){
		return (settings == null || settings.isEmpty()) ? false : true;
	}
	
	public void addSetting(GenericSetting setting){
		if (settings == null){
			settings = new ArrayList<GenericSetting>();
		}
		settings.add(setting);
	}
}