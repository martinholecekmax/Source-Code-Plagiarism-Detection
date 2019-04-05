public class BasicFieldFilter
  implements FieldFilter {
  public static final Log LOG = LogFactory.getLog(BasicFieldFilter.class);
  private Configuration conf;
  private boolean supplemental = false;
  private String[] suppFields = null;
  private boolean isSupplementalField(String name) {
    for (int i = 0; i < suppFields.length; i++) {
      if (name != null && name.equals(suppFields[i])) {
        return true;
      }
    }
    return false;
  }
  public void setConf(Configuration conf) {
    this.conf = conf;
    this.supplemental = conf.getBoolean("index.supplemental", false);
    String suppStr = conf.get("index.supplemental.fields", null);
    if (suppStr != null) {
      suppFields = suppStr.split(",");
    }
  }
  public Configuration getConf() {
    return this.conf;
  }
  public Document filter(String url, Document doc, List<FieldWritable> fields)
    throws IndexingException {
        for (FieldWritable field : fields) {
            FieldType type = field.getType();
      if (type == FieldType.CONTENT) {
        String fieldName = field.getName();
                        if (!supplemental || (supplemental && isSupplementalField(fieldName))) {
                    Field.Store store = field.isStored() ? Field.Store.YES
            : Field.Store.NO;
          Field.Index indexed = field.isIndexed() ? field.isTokenized()
            ? Field.Index.TOKENIZED : Field.Index.UN_TOKENIZED : Field.Index.NO;
          Field docField = new Field(fieldName, field.getValue(), store,
            indexed);
                    float fieldBoost = field.getBoost();
          if (fieldBoost > 0) {
            docField.setBoost(fieldBoost);
          }
                    doc.add(docField);
        }
        else {
          LOG.info("Ignoring " + fieldName + " field for " + url + " supplemental index");
        }
      }
    }
    return doc;
  }
}