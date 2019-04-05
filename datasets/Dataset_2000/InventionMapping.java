public final class InventionMapping implements ColumnsNames.InventionMapping {
	private InventionMapping() { }
    
    private static final String PATH_INVENTION_SKILLS = "/invention_skills";
	
	public static final Uri CONTENT_INVENTION_SKILL_ID_URI_BASE = Uri.parse(EOITConst.SCHEME + ItemContentProvider.AUTHORITY + PATH_INVENTION_SKILLS + Item.PATH_ITEM_ID );
	
    public static final int ITEM_ID_PATH_POSITION = 2;
}