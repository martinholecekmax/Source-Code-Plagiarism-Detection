public interface EdgeVertexConverter
        <ImportVertexType extends BaseVertex,
                ExportVertexType extends BaseVertex,
                ImportEdgeType extends BaseEdge<ImportVertexType>,
                ExportEdgeType extends BaseEdge<ExportVertexType>>
        extends
        VertexConverter<ImportVertexType, ExportVertexType>,
        EdgeConverter<ImportVertexType, ExportVertexType, ImportEdgeType, ExportEdgeType> {
    public ExportEdgeType convert(ImportEdgeType e, ExportVertexType newSource, ExportVertexType newTarget);
    public ExportVertexType convert(ImportVertexType e);
}