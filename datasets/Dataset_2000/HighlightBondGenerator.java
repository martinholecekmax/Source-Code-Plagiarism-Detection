public class HighlightBondGenerator extends BasicBondGenerator 
                                    implements IGenerator {
    public HighlightBondGenerator() {}
    private boolean shouldHighlight(IBond bond, RendererModel model) {
        return !super.bindsHydrogen(bond) || model.getShowExplicitHydrogens();
    }
    public IRenderingElement generate(IAtomContainer ac, RendererModel model) {
        IBond bond = model.getHighlightedBond();
        if (bond != null && shouldHighlight(bond, model)) {
            super.ringSet = super.getRingSet(ac,model);
            double r = model.getHighlightDistance() / model.getScale();
            r /= 2.0;
            Color hColor = model.getHoverOverColor();
            Point2d p = bond.get2DCenter();
            boolean filled = model.getHighlightShapeFilled();
            return new OvalElement(p.x, p.y, r, filled, hColor);
        }
        return new ElementGroup();
    }
}