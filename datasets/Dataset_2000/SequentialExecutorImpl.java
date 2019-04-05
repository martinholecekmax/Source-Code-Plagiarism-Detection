public class SequentialExecutorImpl extends AbstractExecutor implements SequentialExecutor {
    private final java.util.concurrent.Executor runnableExecutor;
    public SequentialExecutorImpl(ContextEvent<ComputationContext> computationContextEvent, ContextEvent<ComputationInstanceContext> computationInstanceContextEvent, Enrichment enrichment, ExecutionConfiguration configuration, java.util.concurrent.Executor runnableExecutor) {
        super(computationContextEvent, computationInstanceContextEvent, enrichment, configuration);
        Validate.notNull(runnableExecutor);
        this.runnableExecutor = runnableExecutor;
    }
    @Override
    public <L extends Mergeable<L>> Execution<L> submit(Computation<L> computation) {
        ComputationContext context = new ComputationContext();
        getComputationContextEvent().initialize(context);
        executeMethodsByAnnotation(getEnrichment(), context, computation, Before.class);
        return new SequentialExecution<>(
                new ComputationId() {
                    @Override
                    public int currentId() {
                        return 0;
                    }
                    @Override
                    public int maxId() {
                        return 0;
                    }
                },
                runnableExecutor,
                computation,
                getEnrichment(),
                getComputationInstanceContextEvent(),
                context
        );
    }
}