public class ShowParameterDialogHandler extends AbstractHandler implements
		IHandler {
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		List<Operation> s = OperationTableViewer.getInstance()
				.getSelectedOperations();
		Operation op = OperationSelectionDialog.getOperation(s);
		if (op == null)
			return null;
		try {
			ExecuteOperationCommand
					.executeOperation(Animator.getAnimator(), op);
		} catch (ProBException e) {
			e.notifyUserOnce();
		}
		return null;
	}
}