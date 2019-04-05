public class GoLiteralCharImpl extends GoPsiElementBase
    implements GoLiteralChar
{
    public GoLiteralCharImpl(@NotNull ASTNode node) {
        super(node);
    }
    @NotNull
    @Override
    public Character getValue() {
        return null;
    }
    @Override
    public Type getType() {
        return Type.Char;
    }
}