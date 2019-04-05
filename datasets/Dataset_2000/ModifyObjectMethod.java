public class ModifyObjectMethod
        extends ManagementMethod {
    public ModifyObjectMethod(JournalEntry parent) {
        super(parent);
    }
    @Override
    public Object invoke(ManagementDelegate delegate) throws ServerException {
        return delegate.modifyObject(parent.getContext(), parent
                .getStringArgument(ARGUMENT_NAME_PID), parent
                .getStringArgument(ARGUMENT_NAME_STATE), parent
                .getStringArgument(ARGUMENT_NAME_LABEL), parent
                .getStringArgument(ARGUMENT_NAME_OWNERID), parent
                .getStringArgument(ARGUMENT_NAME_LOG_MESSAGE), parent
                .getDateArgument(ARGUMENT_NAME_LAST_MODIFIED_DATE));
    }
}