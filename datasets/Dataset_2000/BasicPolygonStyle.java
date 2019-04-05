public class BasicPolygonStyle extends StyleImpl
    implements org.geotools.styling.Style {
    
    public BasicPolygonStyle() {
        this(new FillImpl(), new StrokeImpl());
    }
    public BasicPolygonStyle(Fill fill, Stroke stroke) {
        PolygonSymbolizerImpl polysym = new PolygonSymbolizerImpl();
        polysym.setFill(fill);
        polysym.setStroke(stroke);
        RuleImpl rule = new RuleImpl();
        rule.setSymbolizers(new Symbolizer[] { polysym });
        FeatureTypeStyleImpl fts = new FeatureTypeStyleImpl();
        fts.setRules(new Rule[] { rule });
        this.setFeatureTypeStyles(new FeatureTypeStyle[] { fts });
    }
    public String getAbstract() {
        return "A simple polygon style";
    }
    public String getName() {
        return "default polygon style";
    }
    public String getTitle() {
        return "default polygon style";
    }
}