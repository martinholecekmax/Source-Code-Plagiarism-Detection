public class DocumentsListReader extends DocumentModelReader {
    private Iterator<DocumentModel> iterator;
    public DocumentsListReader(CoreSession session, List<DocumentModel> docsList) {
        super(session);
        iterator = docsList.iterator();
    }
    public static DocumentsListReader createDocumentsListReader(
            CoreSession session, Collection<DocumentRef> docRefsList)
            throws ClientException {
        List<DocumentModel> list = new ArrayList<DocumentModel>();
        for (DocumentRef docRef : docRefsList) {
            DocumentModel doc = session.getDocument(docRef);
            list.add(doc);
        }
        return new DocumentsListReader(session, list);
    }
    @Override
    public void close() {
        super.close();
        iterator = null;
    }
    @Override
    public ExportedDocument read() throws IOException {
        if (iterator.hasNext()) {
            DocumentModel docModel = iterator.next();
            return new ExportedDocumentImpl(docModel, inlineBlobs);
        }
        return null;
    }
}