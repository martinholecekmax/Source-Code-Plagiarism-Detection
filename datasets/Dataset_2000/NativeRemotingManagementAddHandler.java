public class NativeRemotingManagementAddHandler extends AbstractAddStepHandler {
    public static final NativeRemotingManagementAddHandler INSTANCE = new NativeRemotingManagementAddHandler();
    public static final String OPERATION_NAME = ModelDescriptionConstants.ADD;
    @Override
    protected void populateModel(ModelNode operation, ModelNode model) {
        model.setEmptyObject();
    }
    @Override
    protected boolean requiresRuntime(OperationContext context) {
        return true;
    }
    @Override
    protected void performRuntime(OperationContext context, ModelNode operation, ModelNode model, ServiceVerificationHandler verificationHandler, List<ServiceController<?>> newControllers) {
        final ServiceTarget serviceTarget = context.getServiceTarget();
        final ServiceName endpointName = RemotingServices.SUBSYSTEM_ENDPOINT;
        ManagementChannelRegistryService.addService(serviceTarget, endpointName);
        ManagementRemotingServices.installManagementChannelServices(serviceTarget,
                endpointName,
                new ModelControllerClientOperationHandlerFactoryService(),
                Services.JBOSS_SERVER_CONTROLLER,
                ManagementRemotingServices.MANAGEMENT_CHANNEL,
                verificationHandler,
                newControllers);
    }
}