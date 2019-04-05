public interface GraphProcessingObserver {
    
    void graphProcessingStarted(GraphContext graphContext);
    
    void graphProcessingStopped(GraphContext graphContext);
    
    void tileProcessingStarted(GraphContext graphContext, Rectangle tileRectangle);
    
    void tileProcessingStopped(GraphContext graphContext, Rectangle tileRectangle);
}