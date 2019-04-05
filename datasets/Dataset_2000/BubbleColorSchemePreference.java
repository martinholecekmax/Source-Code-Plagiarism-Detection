public class BubbleColorSchemePreference extends ChoiceDockPropertyPreference<ColorScheme>{
	
	public BubbleColorSchemePreference( DockProperties properties ){
		super( properties, BubbleTheme.BUBBLE_COLOR_SCHEME, new Path( "dock.theme.bubble.colorscheme" ), new BubbleColorSchemeChoice( properties ) );
		setLabelId( "preference.theme.bubble.color.label" );
		setDescriptionId( "preference.theme.bubble.color.description" );
	}
}