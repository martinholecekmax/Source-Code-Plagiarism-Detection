public class ASTJAnnotation extends ASTJNode<Annotation> implements JAnnotation
{
  
  private Annotation rewrittenASTNode = null;
  
  protected String contents = UNITIALIZED_STRING;
  
  protected ASTJAnnotation(Annotation annotation)
  {
    super(annotation);
    rewrittenASTNode = annotation;
  }
  @Override
  public void dispose()
  {
    rewrittenASTNode = null;
    contents = null;
    super.dispose();
  }
  
  protected Annotation getRewrittenASTNode()
  {
    return rewrittenASTNode;
  }
  
  protected void setRewrittenASTNode(Annotation rewrittenAnnotation)
  {
    this.rewrittenASTNode = rewrittenAnnotation;
  }
  
  public String getName()
  {
    if (name == UNITIALIZED_STRING)
    {
                        name = "@" + ASTFacadeHelper.toString(getASTNode().getTypeName());
    }
    return name;
  }
  
  public void setName(String name)
  {
    if (name != null)
    {
      name = name.trim();
      if (name.startsWith("@"))
      {
        this.name = name;
        name = name.substring(1);
      }
      else
      {
        this.name = "@" + name;
      }
    }
    else
    {
      this.name = name;
    }
    setNodeProperty(getASTNode(), name, getASTNode().getTypeNameProperty(), ASTNode.SIMPLE_NAME);
  }
  @Override
  public String getContents()
  {
    if (contents == UNITIALIZED_STRING)
    {
      contents = super.getContents();
    }
    return contents;
  }
  public void setContents(String contents)
  {
    if (getParent() != null)
    {
      getParent().childToBeChanged(this);
    }
    this.contents = contents;
    trackAndReplace(getRewrittenASTNode(), contents);
  }  
}