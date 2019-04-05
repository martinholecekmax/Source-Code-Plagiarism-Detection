public class RunNodesException extends Exception {
   
   private static final long serialVersionUID = -2272965726680821281L;
   private final String group;
   private final int count;
   private final Template template;
   private final Set<? extends NodeMetadata> successfulNodes;
   private final Map<? extends NodeMetadata, ? extends Throwable> failedNodes;
   private final Map<?, Exception> executionExceptions;
   public RunNodesException(String group, int count, Template template,
            Set<? extends NodeMetadata> successfulNodes, Map<?, Exception> executionExceptions,
            Map<? extends NodeMetadata, ? extends Throwable> failedNodes) {
      super(
               String
                        .format(
                                 "error running %d node%s group(%s) location(%s) image(%s) size(%s) options(%s)%n%s%n%s",
                                 count, count > 1 ? "s" : "", group, template.getLocation().getId(),
                                 template.getImage().getProviderId(), template.getHardware()
                                          .getProviderId(), template.getOptions(),
                                 createExecutionErrorMessage(executionExceptions),
                                 createNodeErrorMessage(failedNodes)));
      this.group = group;
      this.count = count;
      this.template = template;
      this.successfulNodes = successfulNodes;
      this.failedNodes = failedNodes;
      this.executionExceptions = executionExceptions;
   }
   
   public Set<? extends NodeMetadata> getSuccessfulNodes() {
      return successfulNodes;
   }
   
   public Map<?, ? extends Throwable> getExecutionErrors() {
      return executionExceptions;
   }
   
   public Map<? extends NodeMetadata, ? extends Throwable> getNodeErrors() {
      return failedNodes;
   }
   public String getGroup() {
      return group;
   }
   public int getCount() {
      return count;
   }
   public Template getTemplate() {
      return template;
   }
}