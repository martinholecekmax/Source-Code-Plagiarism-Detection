@RunWith(WithTestDefaultsRunner.class)
public class LayerDrawableTest {
    
    protected Drawable drawable1000;
    protected Drawable drawable2000;
    protected Drawable drawable3000;
    
    protected Drawable[] drawables;
    @Before
    public void setUp() {
        drawable1000 = new BitmapDrawable(BitmapFactory.decodeResource(
                Robolectric.application.getResources(), 0x00001000));
        drawable2000 = new BitmapDrawable(BitmapFactory.decodeResource(
                Robolectric.application.getResources(), 0x00002000));
        drawable3000 = new BitmapDrawable(BitmapFactory.decodeResource(
                Robolectric.application.getResources(), 0x00003000));
        drawables = new Drawable[] { drawable1000, drawable2000, drawable3000 };
    }
    @Test
    public void testConstruction() {
        LayerDrawable layerDrawable = new LayerDrawable(drawables);
        assertSame("drawables", drawables, shadowOf(layerDrawable).drawables);
    }
    @Test
    public void testGetNumberOfLayers() {
        LayerDrawable layerDrawable = new LayerDrawable(drawables);
        assertEquals("count", 3, layerDrawable.getNumberOfLayers());
    }
}