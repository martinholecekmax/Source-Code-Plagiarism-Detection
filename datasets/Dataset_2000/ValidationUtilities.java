public abstract class ValidationUtilities {
    private static Map<String, Pattern> patternCache =
            new ConcurrentHashMap<String, Pattern>();
    
    public static boolean isValid(Annotation annotation)
            throws PatternSyntaxException {
        return isValid(annotation.getDefinition(), annotation.getValue());
    }
    
    public static boolean isValid(AnnotationDefinition annoDef, String value)
            throws PatternSyntaxException {
        if (annoDef == null) {
            throw new InvalidArgument("annoDef", annoDef);
        }
        if (annoDef.getType() == null) {
            return false;
        }
        switch (annoDef.getType()) {
        case ENUMERATION:
            return validateEnumeration(annoDef.getEnums(), value);
        case REGULAR_EXPRESSION:
            return validateRegExp(annoDef.getValue(), value);
        default:
            return false;
        }
    }
    
    private static boolean validateEnumeration(
            Collection<String> allowedValues, String value) {
        return (allowedValues != null && allowedValues.contains(value));
    }
    
    protected static boolean validateRegExp(String pattern, String value)
            throws PatternSyntaxException {
        Pattern re = patternCache.get(pattern);
        if (re == null) {
            re = compile(pattern, MULTILINE | DOTALL);
            patternCache.put(pattern, re);
        }
        return (re.matcher(value).matches());
    }
}