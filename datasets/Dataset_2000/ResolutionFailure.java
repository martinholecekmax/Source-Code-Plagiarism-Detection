public abstract class ResolutionFailure implements Cloneable {
  
  public static enum Status {
    
    ADDITIONAL_REQUIREMENT,
    
    COULD_NOT_RESOLVE,
    
    GET_ADDITIONAL_REQUIREMENTS_FAILED,
    
    GET_RESULTS_FAILED,
    
    GET_REQUIREMENTS_FAILED,
    
    LATE_RESOLUTION_FAILURE,
    
    MARKET_DATA_MISSING,
    
    NO_FUNCTIONS,
    
    RECURSIVE_REQUIREMENT,
    
    UNSATISFIED,
    
    SUPPRESSED
  }
  ResolutionFailure() {
  }
    protected abstract ResolutionFailure additionalRequirement(final ValueRequirement valueRequirement, final ResolutionFailure failure);
  protected abstract ResolutionFailure requirement(final ValueRequirement valueRequirement, final ResolutionFailure failure);
  protected abstract ResolutionFailure requirements(final Map<ValueSpecification, ValueRequirement> available);
  protected abstract ResolutionFailure getResultsFailed();
  protected abstract ResolutionFailure getAdditionalRequirementsFailed();
  protected abstract ResolutionFailure lateResolutionFailure();
  protected abstract ResolutionFailure getRequirementsFailed();
  protected abstract ResolutionFailure assertValueRequirement(final ValueRequirement valueRequirement);
  protected abstract ResolutionFailure suppressed();
    public abstract ValueRequirement getValueRequirement();
  public abstract <T> Collection<T> accept(final ResolutionFailureVisitor<T> visitor);
    
  protected abstract void merge(final ResolutionFailure failure);
    @Override
  public abstract String toString();
  @Override
  public abstract Object clone();
  
  @Override
  public abstract boolean equals(final Object obj);
  @Override
  public abstract int hashCode();
}