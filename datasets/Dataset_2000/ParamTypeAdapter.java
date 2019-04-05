public class ParamTypeAdapter implements JsonSerializer<Parameter.ParamType>, JsonDeserializer<Parameter.ParamType> {
    public JsonElement serialize(Parameter.ParamType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.name().toLowerCase());
    }
    public Parameter.ParamType deserialize(JsonElement json, Type classOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return Parameter.ParamType.valueOf(json.getAsString().toUpperCase());
    }
}