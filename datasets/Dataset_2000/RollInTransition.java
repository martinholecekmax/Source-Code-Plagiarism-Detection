public class RollInTransition extends CachedTimelineTransition {
    
    public RollInTransition(final Node node) {
        super(node, null);
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0.2));
    }
    @Override protected void starting() {
        super.starting();
        timeline = TimelineBuilder.create()
            .keyFrames(
                new KeyFrame(Duration.millis(0),    
                    new KeyValue(node.opacityProperty(), 0, WEB_EASE),
                    new KeyValue(node.translateXProperty(), -node.getBoundsInLocal().getWidth(), WEB_EASE),
                    new KeyValue(node.rotateProperty(), -120, WEB_EASE)
                ),
                new KeyFrame(Duration.millis(1000),    
                    new KeyValue(node.opacityProperty(), 1, WEB_EASE),
                    new KeyValue(node.translateXProperty(), 0, WEB_EASE),
                    new KeyValue(node.rotateProperty(), 0, WEB_EASE)
                )
            )
            .build();
    }
}