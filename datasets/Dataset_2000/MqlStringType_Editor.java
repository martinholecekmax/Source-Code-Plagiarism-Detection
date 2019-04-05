public class MqlStringType_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_9cxhn0_a(editorContext, node);
  }
  private EditorCell createCollection_9cxhn0_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_9cxhn0_a");
    editorCell.addEditorCell(this.createConstant_9cxhn0_a0(editorContext, node));
    return editorCell;
  }
  private EditorCell createConstant_9cxhn0_a0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "string");
    editorCell.setCellId("Constant_9cxhn0_a0");
    MqlSS_StyleSheet.getKeyword(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.EDITABLE, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }
}