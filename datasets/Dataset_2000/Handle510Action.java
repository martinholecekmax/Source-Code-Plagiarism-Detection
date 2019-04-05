public class Handle510Action implements MARCXMLAction
{
    public void processElement(Resources resource, Object o, InfiniteProgressPanel progressPanel) throws UnsupportedRepeatingDataTypeException {
		DataFieldType dataField = (DataFieldType) o;
		String titles[] = {"3","a","b","c","x"};
		Vector <String> titlesV;
		titlesV = MARCIngest.arrayToVector(titles);
		String noteTitle = "Bibliographic References";
		NotesEtcTypes noteType = NoteEtcTypesUtils.lookupNoteEtcTypeByCannonicalName("Bibliography");
		String title = MARCIngest.getSpecificSubCodeValuesAsDelimitedString(dataField,titlesV,",");
		ArchDescriptionNotes adn = new ArchDescriptionNotes(resource,noteTitle,NotesEtcTypes.DATA_TYPE_NOTE,resource.getRepeatingData().size()+1,noteType,title);
        adn.setPersistentId(resource.getNextPersistentIdAndIncrement());
        resource.addRepeatingData(adn);
	}
    public List getChildren(Object element)
    {
        return null;
    }
}