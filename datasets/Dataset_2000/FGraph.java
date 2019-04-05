public class FGraph implements Finder {
    
    protected Graph graph;
    
    public FGraph(Graph graph) {
        this.graph = graph;
    }
    
    @Override
    public ExtendedIterator<Triple> find(TriplePattern pattern) {
        if (graph == null) return new NullIterator<Triple>();
        return graph.find(pattern.asTripleMatch());
    }
    
    @Override
    public ExtendedIterator<Triple> findWithContinuation(TriplePattern pattern, Finder continuation) {
        if (graph == null) return new NullIterator<Triple>();
        if (continuation == null) {
            return graph.find(pattern.asTripleMatch());
        } else {
            return graph.find(pattern.asTripleMatch()).andThen(continuation.find(pattern));
        }
    }
    
    public Graph getGraph() {
        return graph;
    }
    
    @Override
    public boolean contains(TriplePattern pattern) {
        return graph.contains(pattern.getSubject(), pattern.getPredicate(), pattern.getObject());
    }
}