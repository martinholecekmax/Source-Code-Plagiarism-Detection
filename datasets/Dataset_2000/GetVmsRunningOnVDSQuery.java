public class GetVmsRunningOnVDSQuery<P extends GetVmsRunningOnVDSParameters> extends QueriesCommandBase<P> {
    public GetVmsRunningOnVDSQuery(P parameters) {
        super(parameters);
    }
    @Override
    protected void executeQueryCommand() {
        getQueryReturnValue().setReturnValue(
                DbFacade.getInstance().getVmDao().getAllRunningByVds(getParameters().getId()));
            }
}