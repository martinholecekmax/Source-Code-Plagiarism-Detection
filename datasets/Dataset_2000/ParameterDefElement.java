public class ParameterDefElement extends ParameterElement implements ItemPresentation {
    public ParameterDefElement(@NotNull ASTNode node) {
        super(node);
    }
    @Override
    public String getPresentableText() {
        return getName();
    }
    @Override
    public String getLocationString() {
        return getTemplateName();
    }
    @Override
    public Icon getIcon(boolean open) {
        return getNode().getElementType() == SoyElement.doc_comment_param_def ? SoyIcons.PARAMETER : null;
    }
    @Override
    public boolean isDefinitionElement() {
        return true;
    }
}