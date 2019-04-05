public class TransDistParams<SupportType> {
  private final Observation _obs;
  private final Set<SupportType> _support;
  private final SupportType _currState;
  private final SupportType _nextState;
  public TransDistParams(Observation obs, Set<SupportType> support,
      SupportType currState, SupportType nextState) {
    _obs = obs;
    _support = support;
    _currState = currState;
    _nextState = nextState;
  }
  public Observation getObservation() {
    return _obs;
  }
  public Set<SupportType> getSupport() {
    return _support;
  }
  public SupportType getCurrentState() {
    return _currState;
  }
  public SupportType getNextState() {
    return _nextState;
  }
}