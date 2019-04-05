public interface StateComputer<D extends DPState> {
  
  void setStateID(int stateID);
  int getStateID();
  D computeState(Rule rule, List<HGNode> antNodes, int spanStart, int spanEnd, SourcePath srcPath);
  D computeFinalState(HGNode antNode, int spanStart, int spanEnd, SourcePath srcPath);
}