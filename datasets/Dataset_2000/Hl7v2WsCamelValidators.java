public class Hl7v2WsCamelValidators {
    private static final Validator<Object, Object> PCD01_VALIDATOR = new Pcd01Validator();
    private static final Validator<Object, Object> CONTINUA_WAN_VALIDATOR = new ContinuaWanValidator();
    
    public static Processor pcd01RequestValidator() {
        return newValidatingProcessor(PCD01_VALIDATOR, Pcd01Component.HL7V2_CONFIG.getParser());
    }
    
    public static Processor pcd01ResponseValidator() {
        return newValidatingProcessor(PCD01_VALIDATOR, Pcd01Component.HL7V2_CONFIG.getParser());
    }
    
    public static Processor continuaWanRequestValidator() {
        return newValidatingProcessor(CONTINUA_WAN_VALIDATOR, Pcd01Component.HL7V2_CONFIG.getParser());
    }
    
    public static Processor continuaWanResponseValidator() {
        return newValidatingProcessor(CONTINUA_WAN_VALIDATOR, Pcd01Component.HL7V2_CONFIG.getParser());
    }
    private static Processor newValidatingProcessor(final Validator<Object,Object> validator , final Parser parser) {
        return new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                doValidate(exchange, validator, parser);
            }
        };
    }
    private static void doValidate(Exchange exchange, Validator<Object, Object> validator, Parser parser) throws Exception {
        if (! validationEnabled(exchange)) {
            return;
        }
        MessageAdapter<?> msg = Hl7v2MarshalUtils.extractMessageAdapter(
                exchange.getIn(),
                exchange.getProperty(Exchange.CHARSET_NAME, String.class),
                parser);
        validator.validate(msg, null);
    }
}