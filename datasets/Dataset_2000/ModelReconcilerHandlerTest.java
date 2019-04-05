public abstract class ModelReconcilerHandlerTest extends ModelReconcilerTest {
	public void testHandler_Command_Set() {
		MApplication application = createApplication();
		MCommand command = CommandsFactoryImpl.eINSTANCE.createCommand();
		application.getCommands().add(command);
		MHandler handler = CommandsFactoryImpl.eINSTANCE.createHandler();
		application.getHandlers().add(handler);
		saveModel();
		ModelReconciler reconciler = createModelReconciler();
		reconciler.recordChanges(application);
		handler.setCommand(command);
		Object state = reconciler.serialize();
		application = createApplication();
		command = application.getCommands().get(0);
		handler = application.getHandlers().get(0);
		Collection<ModelDelta> deltas = constructDeltas(application, state);
		handler = application.getHandlers().get(0);
		assertNull(handler.getCommand());
		applyAll(deltas);
		handler = application.getHandlers().get(0);
		assertEquals(command, handler.getCommand());
	}
	public void testHandler_Command_Unset() {
		MApplication application = createApplication();
		MCommand command = CommandsFactoryImpl.eINSTANCE.createCommand();
		application.getCommands().add(command);
		MHandler handler = CommandsFactoryImpl.eINSTANCE.createHandler();
		handler.setCommand(command);
		application.getHandlers().add(handler);
		saveModel();
		ModelReconciler reconciler = createModelReconciler();
		reconciler.recordChanges(application);
		handler.setCommand(null);
		Object state = reconciler.serialize();
		application = createApplication();
		command = application.getCommands().get(0);
		handler = application.getHandlers().get(0);
		Collection<ModelDelta> deltas = constructDeltas(application, state);
		handler = application.getHandlers().get(0);
		assertEquals(command, handler.getCommand());
		applyAll(deltas);
		handler = application.getHandlers().get(0);
		assertNull(handler.getCommand());
	}
}