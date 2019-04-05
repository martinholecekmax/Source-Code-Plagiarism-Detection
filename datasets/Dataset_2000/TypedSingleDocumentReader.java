public class TypedSingleDocumentReader extends SingleDocumentReader {
    public TypedSingleDocumentReader(CoreSession session, DocumentModel root) {
        super(session, root);
    }
    public TypedSingleDocumentReader(CoreSession session, DocumentRef root)
            throws ClientException {
        this(session, session.getDocument(root));
    }
    @Override
    public ExportedDocument read() throws IOException {
        if (doc != null) {
            if (readDone && !enableRepeatedReads) {
                return null;
            } else {
                readDone = true;
                return new TypedExportedDocumentImpl(doc);
            }
        }
        doc = null;
        return null;
    }
}