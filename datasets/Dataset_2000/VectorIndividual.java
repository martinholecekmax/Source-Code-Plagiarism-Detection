public abstract class VectorIndividual extends Individual
    {
    
    public void defaultCrossover(EvolutionState state, int thread, 
        VectorIndividual ind) { }
    
    public void defaultMutate(EvolutionState state, int thread) { reset(state,thread); }
    
    public abstract void reset(EvolutionState state, int thread);
    
    public Object getGenome() { return null; }
    
    public void setGenome(Object gen) { }
    
    public int genomeLength() { return 0; }
    
    public void reset(EvolutionState state, int thread, int newSize)
        {
        setGenomeLength(newSize);
        reset(state, thread);
        }
    
    public void setGenomeLength(int len) { }
    
    public void split(int[] points, Object[] pieces) { }
    
    public void join(Object[] pieces) { }
    
    public void cloneGenes(Object piece) { }      public long size() { return genomeLength(); }
    }