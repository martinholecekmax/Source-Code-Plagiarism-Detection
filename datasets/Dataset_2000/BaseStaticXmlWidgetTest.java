public class BaseStaticXmlWidgetTest
	extends TestCase {
				public static void testBaseStaticXmlWidget() {
		BaseStaticXmlWidget widget = new BaseStaticXmlWidget( null, "foo", "foo.com" ) {
					};
		assertEquals( "<foo/>", widget.toString() );
		widget.putAttribute( "bar", "" );
		widget.putAttribute( "baz", "BAZ" );
		widget.putAttribute( "abc", null );
		assertEquals( "<foo bar=\"\" baz=\"BAZ\"/>", widget.toString() );
	}
}