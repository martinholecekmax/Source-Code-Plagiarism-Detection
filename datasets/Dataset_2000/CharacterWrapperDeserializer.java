public class CharacterWrapperDeserializer extends PrimitiveDeserializer<Character> {
    
    public Character deserialize(String value) {
        return isBlank(value) ?  null : value.charAt(0);
    }
}