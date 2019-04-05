public class UnsignedIntegerOneByteDatatype extends AbstractDatatype<UnsignedIntegerOneByte> {
    public UnsignedIntegerOneByte valueOf(String s) throws InvalidValueException {
        if (s.equals("")) return null;
        try {
            return new UnsignedIntegerOneByte(s);
        } catch (NumberFormatException ex) {
            throw new InvalidValueException("Can't convert string to number or not in range: " + s, ex);
        }
    }
}