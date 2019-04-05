public enum AsciiCompatibility {
    CONVERTER, DECODER, ENCODER;
    boolean isConverter() {
        return this == CONVERTER;
    }
    boolean isDecoder() {
        return this == DECODER;
    }
    boolean isEncoder() {
        return this == ENCODER;
    }
}