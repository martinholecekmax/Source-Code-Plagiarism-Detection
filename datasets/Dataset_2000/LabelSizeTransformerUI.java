@ServiceProvider(service = TransformerUI.class, position = 400)
public class LabelSizeTransformerUI extends AbstractTransformerUI<SizeTransformerPanel> {
    @Override
    public Icon getIcon() {
        return new ImageIcon(getClass().getResource("/org/mongkie/ui/vm/resources/font_size.png"));
    }
    @Override
    public String getDisplayName() {
        return "Font Size";
    }
    @Override
    public boolean isUIForTransformer(Transformer transformer) {
        return transformer instanceof LabelSizeTransformer;
    }
    @Override
    protected SizeTransformerPanel buildPanel(Transformer transformer, Ranking ranking) {
        return new SizeTransformerPanel(transformer, ranking);
    }
    @Override
    protected void refresh(SizeTransformerPanel panel, Ranking ranking) {
        panel.refresh(ranking);
    }
    @Override
    protected void transformerApplied(SizeTransformerPanel panel) {
    }
}