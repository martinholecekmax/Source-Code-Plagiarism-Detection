@SuppressWarnings("serial")
public class DefaultTupleDocumentConverter implements TupleDocumentConverter {
	public SolrInputDocument convert(ITuple key, NullWritable value) throws IOException {
		SolrInputDocument document = new SolrInputDocument();
		for(Field field : key.getSchema().getFields()) {
			checkFieldType(field);
			if(field.getType().equals(Type.STRING)) {
								document.setField(field.getName(), key.get(field.getName()).toString());
			} else { 				document.setField(field.getName(), key.get(field.getName()));
			}
		}
		return document;
	}
	public void checkFieldType(Field field) throws IOException {
		if(field.getType().equals(Type.INT)) {
			return;
		} else if(field.getType().equals(Type.LONG)) {
			return;
		} else if(field.getType().equals(Type.STRING)) {
			return;
		} else if(field.getType().equals(Type.DOUBLE)) {
			return;
		} else if(field.getType().equals(Type.FLOAT)) {
			return;
		} else if(field.getType().equals(Type.BOOLEAN)) {
			return;
		} else {
			throw new IOException("Field type: " + field.getType() + " not supported for Tuple SOLR indexing!");
		}
	}
}