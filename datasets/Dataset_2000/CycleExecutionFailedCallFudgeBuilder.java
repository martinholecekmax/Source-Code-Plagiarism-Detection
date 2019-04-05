@FudgeBuilderFor(CycleExecutionFailedCall.class)
public class CycleExecutionFailedCallFudgeBuilder implements FudgeBuilder<CycleExecutionFailedCall> {
  private static final String EXECUTION_OPTIONS_FIELD = "executionOptions";
  private static final String EXCEPTION_FIELD = "exception";
  @Override
  public MutableFudgeMsg buildMessage(FudgeSerializer serializer, CycleExecutionFailedCall object) {
    MutableFudgeMsg msg = serializer.newMessage();
    serializer.addToMessage(msg, EXECUTION_OPTIONS_FIELD, null, object.getExecutionOptions());
    serializer.addToMessage(msg, EXCEPTION_FIELD, null, object.getException());
    return msg;
  }
  @Override
  public CycleExecutionFailedCall buildObject(FudgeDeserializer deserializer, FudgeMsg msg) {
    ViewCycleExecutionOptions cycleExecutionOptions = deserializer.fieldValueToObject(ViewCycleExecutionOptions.class, msg.getByName(EXECUTION_OPTIONS_FIELD));
    FudgeField exceptionField = msg.getByName(EXCEPTION_FIELD);
    Exception exception = exceptionField != null ? deserializer.fieldValueToObject(Exception.class, exceptionField) : null;
    return new CycleExecutionFailedCall(cycleExecutionOptions, exception);
  }
}