public abstract class GraphAlgoFactory
{
    
    public static PathFinder<Path> allPaths( RelationshipExpander expander, int maxDepth )
    {
        return new AllPaths( maxDepth, expander );
    }
    
    public static PathFinder<Path> allSimplePaths( RelationshipExpander expander,
            int maxDepth )
    {
        return new AllSimplePaths( maxDepth, expander );
    }
    
    public static PathFinder<Path> shortestPath( RelationshipExpander expander, int maxDepth )
    {
        return new ShortestPath( maxDepth, expander );
    }
    
    public static PathFinder<Path> pathsWithLength( RelationshipExpander expander, int length )
    {
        return new ShortestPath( length, expander, true );
    }
    
    public static PathFinder<WeightedPath> aStar( RelationshipExpander expander,
            CostEvaluator<Double> lengthEvaluator, EstimateEvaluator<Double> estimateEvaluator )
    {
        return new AStar( expander, lengthEvaluator, estimateEvaluator );
    }
    
    public static PathFinder<WeightedPath> dijkstra( RelationshipExpander expander,
            CostEvaluator<Double> costEvaluator )
    {
        return new Dijkstra( expander, costEvaluator );
    }
    
    public static PathFinder<WeightedPath> dijkstra( RelationshipExpander expander,
            String relationshipPropertyRepresentingCost )
    {
        return dijkstra( expander, new DoubleEvaluator( relationshipPropertyRepresentingCost ) );
    }
}