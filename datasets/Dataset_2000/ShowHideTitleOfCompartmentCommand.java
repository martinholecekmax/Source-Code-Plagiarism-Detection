public class ShowHideTitleOfCompartmentCommand extends SetPropertyCommand {
	
	public ShowHideTitleOfCompartmentCommand(TransactionalEditingDomain domain, View view, boolean visibility) {
		super(domain, new EObjectAdapter(view), Properties.ID_SHOWCOMPARTMENTTITLE, "Show/Hide Compartment Title", Boolean.valueOf(visibility)); 	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		return super.doExecuteWithResult(progressMonitor, info);
	}
}