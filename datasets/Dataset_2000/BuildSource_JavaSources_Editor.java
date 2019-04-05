public class BuildSource_JavaSources_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCustom_uremau_a(editorContext, node);
  }
  private EditorCell createCustom_uremau_a(final EditorContext editorContext, final SNode node) {
    AbstractCellProvider provider = new _FunctionTypes._return_P0_E0<AbstractCellProvider>() {
      public AbstractCellProvider invoke() {
        return new AbstractCellProvider() {
          public EditorCell createEditorCell(EditorContext context) {
            EditorCell_Error result = new EditorCell_Error(editorContext, node, "<no sources>");
            result.getStyle().set(StyleAttributes.PADDING_LEFT, new Padding(0.0));
            result.getStyle().set(StyleAttributes.PADDING_RIGHT, new Padding(0.0));
            return result;
          }
        };
      }
    }.invoke();
    EditorCell editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("Custom_uremau_a");
    return editorCell;
  }
}