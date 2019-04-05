public class ContextCapturePauseHandler extends AbstractHandler 		implements IElementUpdater {
	private final AbstractContextListener CONTEXT_LISTENER = new AbstractContextListener() {
		@Override
		public void contextActivated(IInteractionContext context) {
			resume();
		}
		@Override
		public void contextDeactivated(IInteractionContext context) {
			resume();
		}
	};
	public ContextCapturePauseHandler() {
		ContextCore.getContextManager().addListener(CONTEXT_LISTENER);
	}
	@Override
	public void dispose() {
		ContextCore.getContextManager().removeListener(CONTEXT_LISTENER);
		super.dispose();
	}
	public Object execute(ExecutionEvent e) throws ExecutionException {
		if (ContextCore.getContextManager().isContextCapturePaused()) {
			resume();
		} else {
			pause();
		}
		return null;
	}
	public void resume() {
		ContextCore.getContextManager().setContextCapturePaused(false);
		if (TaskListView.getFromActivePerspective() != null) {
			TaskListView.getFromActivePerspective().indicatePaused(false);
		}
		refreshCommands();
	}
	public void pause() {
		ContextCore.getContextManager().setContextCapturePaused(true);
		TaskListView.getFromActivePerspective().indicatePaused(true);
		refreshCommands();
	}
	private void refreshCommands() {
		ICommandService service = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		if (service != null) {
			service.refreshElements("org.eclipse.mylyn.tasks.ui.command.previousTask", null);
			service.refreshElements("org.eclipse.mylyn.ui.context.capture.pause.command", null);
		}
	}
	@SuppressWarnings("rawtypes")
	public void updateElement(UIElement element, Map parameters) {
		element.setChecked(ContextCore.getContextManager().isContextCapturePaused());
	}
}