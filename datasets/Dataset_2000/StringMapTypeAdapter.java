@SuppressWarnings("rawtypes")
public class StringMapTypeAdapter implements JsonDeserializer<Map> {
    @Override
    public Map deserialize(JsonElement src, Type srcType,
            JsonDeserializationContext context) throws JsonParseException {
        Map<String, String> obj = new HashMap<String, String>();
        JsonObject json = src.getAsJsonObject();
        for(Entry<String, JsonElement> entry : json.entrySet()) {
            obj.put(entry.getKey(), entry.getValue().getAsString());
        }
        return obj;
    }
}