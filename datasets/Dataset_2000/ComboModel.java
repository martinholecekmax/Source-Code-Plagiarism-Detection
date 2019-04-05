public class ComboModel extends BaseModel {
	public ComboModel(String name, String abbr) {
		set("name", name);
		set("abbr", abbr);
	}
	public ComboModel(String name) {
		set("name", name);
	}
	public ComboModel(JSONValue name) {
		set("name", name);
	}
	public String getName(String name) {
		return (String) get("name");
	}
	public String getValue(String value) {
		return (String) get("value");
	}
	public String toString() {
		return get("name");
	}
}