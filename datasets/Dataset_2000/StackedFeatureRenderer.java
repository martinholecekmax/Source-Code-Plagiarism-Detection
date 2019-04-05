public class StackedFeatureRenderer
extends AbstractChangeable
implements FeatureRenderer {
  public static final ChangeType RENDERERS = new ChangeType(
    "The renderers have changed",
    StackedFeatureRenderer.class,
    "RENDERERS",
    SequenceRenderContext.LAYOUT
  );
  private List renderers = new ArrayList();
  public StackedFeatureRenderer() {}
    public void addRenderer(FeatureRenderer renderer) {
    renderers.add(renderer);
  }
  public void removeRenderer(FeatureRenderer renderer) {
    renderers.remove(renderer);
  }
  public double getDepth(SequenceRenderContext src) {
    double depth = 0.0;
    for(Iterator i = renderers.iterator(); i.hasNext(); ) {
      FeatureRenderer fr = (FeatureRenderer) i.next();
      depth += fr.getDepth(src);
    }
    return depth;
  }
  public void renderFeature(
    Graphics2D g,
    Feature f, 
    SequenceRenderContext src
  ) {
    AffineTransform at = g.getTransform();
    Shape oldClip = g.getClip();
    for(Iterator i = renderers.iterator(); i.hasNext(); ) {
      FeatureRenderer fr = (FeatureRenderer) i.next();
      fr.renderFeature(g, f, src);
      double depth = fr.getDepth(src);
      g.translate(0.0, depth);
    }
    g.setClip(oldClip);
    g.setTransform(at);
  }
  public FeatureHolder processMouseEvent(
    FeatureHolder hits,
    SequenceRenderContext src,
    MouseEvent me
  ) {
    return hits;
  }
}