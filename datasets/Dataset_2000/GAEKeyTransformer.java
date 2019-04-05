public class GAEKeyTransformer implements Transformer {
    public Object fromString(String s) {
        return KeyFactory.stringToKey(s);
    }
    public String toString(Object customType) {
        Key key = (Key) customType;
        return KeyFactory.keyToString(key);
    }
}