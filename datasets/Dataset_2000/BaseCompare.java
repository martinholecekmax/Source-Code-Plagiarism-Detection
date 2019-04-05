public abstract class BaseCompare extends SimpleMapOperation {
    public static Boolean doRealCompare(Object value1, Object value2, String operator, String type, String format, List<Object> messages, Locale locale, ClassLoader loader, boolean value2InlineConstant) {
        return ObjectType.doRealCompare(value1, value2, operator, type, format, messages, locale, loader, value2InlineConstant);
    }
    String format;
    String operator;
    String type;
    public BaseCompare(Element element, SimpleMapProcess simpleMapProcess) {
        super(element, simpleMapProcess);
        this.operator = element.getAttribute("operator");
        this.type = element.getAttribute("type");
        this.format = element.getAttribute("format");
    }
    public void doCompare(Object value1, Object value2, List<Object> messages, Locale locale, ClassLoader loader, boolean value2InlineConstant) {
        Boolean success = BaseCompare.doRealCompare(value1, value2, this.operator, this.type, this.format, messages, locale, loader, value2InlineConstant);
        if (success != null && success.booleanValue() == false) {
            addMessage(messages, loader, locale);
        }
    }
    @Override
    public void exec(Map<String, Object> inMap, Map<String, Object> results, List<Object> messages, Locale locale, ClassLoader loader) {
    }
}