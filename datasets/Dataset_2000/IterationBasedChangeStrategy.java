public class IterationBasedChangeStrategy implements ChangeStrategy {
    private ControlParameter resolution;
    
    public IterationBasedChangeStrategy() {
        this.resolution = ConstantControlParameter.of(1.0);
    }
    
    @Override
    public boolean shouldApply(Problem problem) {
        int iterations = AbstractAlgorithm.get().getIterations();
        if (iterations != 0 && iterations % Double.valueOf(resolution.getParameter()).intValue() == 0)
           return true;
        return false;
    }
}