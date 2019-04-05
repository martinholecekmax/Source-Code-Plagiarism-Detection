public class OverflowActionResolver implements ModelNodeResolver<String> {
    public static final OverflowActionResolver INSTANCE = new OverflowActionResolver();
    private OverflowActionResolver() {
    }
    @Override
    public String resolveValue(final OperationContext context, final ModelNode value) throws OperationFailedException {
        try {
            return OverflowAction.valueOf(value.asString()).toString();
        } catch (IllegalArgumentException e) {
            throw createOperationFailure(MESSAGES.invalidOverflowAction(value.asString()));
        }
    }
}