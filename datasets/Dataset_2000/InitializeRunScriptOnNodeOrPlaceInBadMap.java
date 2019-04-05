public class InitializeRunScriptOnNodeOrPlaceInBadMap implements Callable<RunScriptOnNode> {
   public interface Factory {
      Callable<RunScriptOnNode> create(NodeMetadata node, Statement script, RunScriptOptions options,
               Map<NodeMetadata, Exception> badNodes);
   }
   private final RunScriptOnNode.Factory runScriptOnNodeFactory;
   private final Statement script;
   private final Map<NodeMetadata, Exception> badNodes;
   private final NodeMetadata node;
   private final RunScriptOptions options;
   @Inject
   InitializeRunScriptOnNodeOrPlaceInBadMap(RunScriptOnNode.Factory runScriptOnNodeFactory,
            @Assisted NodeMetadata node, @Assisted Statement script, @Assisted RunScriptOptions options,
            @Assisted Map<NodeMetadata, Exception> badNodes) {
      this.runScriptOnNodeFactory = checkNotNull(runScriptOnNodeFactory, "runScriptOnNodeFactory");
      this.script = checkNotNull(script, "script");
      this.badNodes = checkNotNull(badNodes, "badNodes");
      this.node = checkNotNull(node, "node");
      this.options = checkNotNull(options, "options");
   }
   @Override
   public RunScriptOnNode call() throws Exception {
      try {
         return runScriptOnNodeFactory.create(node, script, options).init();
      } catch (Exception e) {
         badNodes.put(node, e);
         return null;
      }
   }
   @Override
   public String toString() {
      return Objects.toStringHelper(this).add("node", node).add("options", options).toString();
   }
}