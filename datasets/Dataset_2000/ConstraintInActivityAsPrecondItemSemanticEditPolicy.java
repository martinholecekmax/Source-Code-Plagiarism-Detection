public class ConstraintInActivityAsPrecondItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	
	public ConstraintInActivityAsPrecondItemSemanticEditPolicy() {
		super(UMLElementTypes.Constraint_3002);
	}
	
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(true);
		EAnnotation annotation = view.getEAnnotation("Shortcut"); 		if(annotation == null) {
						addDestroyShortcutsCommand(cmd, view);
						List<EObject> todestroy = new ArrayList<EObject>();
			todestroy.add(req.getElementToDestroy());
						cmd.add(new EMFtoGMFCommandWrapper(new org.eclipse.emf.edit.command.DeleteCommand(getEditingDomain(), todestroy)));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}
}