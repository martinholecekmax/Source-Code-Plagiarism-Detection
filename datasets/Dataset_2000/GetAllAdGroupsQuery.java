public class GetAllAdGroupsQuery<P extends VdcQueryParametersBase> extends QueriesCommandBase<P> {
    public GetAllAdGroupsQuery(P parameters) {
        super(parameters);
    }
    @Override
    protected void executeQueryCommand() {
        getQueryReturnValue().setReturnValue(DbFacade.getInstance().getAdGroupDao().getAll());
    }
}