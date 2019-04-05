public class DawnAcoreEditPartFactory extends AcoreEditPartFactory
{
  public DawnAcoreEditPartFactory()
  {
    super();
    AcoreDiagramEditorPlugin.getInstance().logInfo("Using DawnAcoreEditPartFactory instead of the original one");
  }
  @Override
  public EditPart createEditPart(EditPart context, Object model)
  {
    if (model instanceof View)
    {
      View view = (View)model;
      switch (AcoreVisualIDRegistry.getVisualID(view))
      {
      case DawnACoreRootEditPart.VISUAL_ID:
        return new DawnACoreRootEditPart(view);
      }
    }
    return super.createEditPart(context, model);
  }
}