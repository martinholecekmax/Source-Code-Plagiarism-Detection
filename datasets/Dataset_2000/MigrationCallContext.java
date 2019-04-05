public class MigrationCallContext extends CallContextBase {
    private final DateTime createdDate;
    private final DateTime updatedDate;
    public MigrationCallContext(final CallContext context, final DateTime createdDate, final DateTime updatedDate) {
        super(context.getTenantId(), context.getUserName(), context.getCallOrigin(), context.getUserType());
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
    @Override
    public DateTime getCreatedDate() {
        return createdDate;
    }
    @Override
    public DateTime getUpdatedDate() {
        return updatedDate;
    }
}