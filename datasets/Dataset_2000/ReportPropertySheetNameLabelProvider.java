public class ReportPropertySheetNameLabelProvider extends ColumnLabelProvider implements
		IStyledLabelProvider
{
	public String getText( Object element )
	{
		String text = getStyledText( element ).toString( );
		System.out.println( text );
		return text;
	}
	public StyledString getStyledText( Object element )
	{
		String value = null;
		if ( element instanceof List )
		{
			GroupPropertyHandle property = ( (GroupPropertyHandleWrapper) ( ( (List) element ).get( 0 ) ) ).getModel( );
			value = property.getPropertyDefn( ).getGroupName( );
		}
		else if ( element instanceof PropertySheetRootElement )
		{
			value = ( (PropertySheetRootElement) element ).getDisplayName( );
		}
		else
		{
			GroupPropertyHandle property = ( (GroupPropertyHandleWrapper) element ).getModel( );
			value = property.getPropertyDefn( ).getDisplayName( );
		}
		if ( value == null )
			value = ""; 		StyledString styledString = new StyledString( );
		styledString.append( value );
		return styledString;
	}
}