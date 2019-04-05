public abstract class DoubleIterativeDeconvolver3D extends Deconvolver3D {
    
    protected static final DoubleAlgebra alg = DoubleAlgebra.DEFAULT;
    
    protected int maxIters;
    
    protected boolean useThreshold;
    
    protected double threshold;
    
    protected boolean logConvergence;
    
    protected String name;
    
    protected DoubleIterativeDeconvolver3D(String name, EvStack[][][] imPSF, PreconditionerType preconditioner, double preconditionerTol, BoundaryType boundary, ResizingType resizing, boolean useThreshold, double threshold, int maxIters,
            boolean logConvergence) {
        this.name = name;
        this.useThreshold = useThreshold;
        this.threshold = threshold;
        this.maxIters = maxIters;
        this.logConvergence = logConvergence;
        this.preconditioner=preconditioner;
        this.preconditionerTol=preconditionerTol;
        this.boundary=boundary;
        this.resizing=resizing;
        this.imPSF=imPSF;
    }
    protected final PreconditionerType preconditioner;
    protected final double preconditionerTol;
    protected final BoundaryType boundary;
    protected final ResizingType resizing;
    protected final EvStack[][][] imPSF;
    
    
    
}