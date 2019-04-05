public abstract class IcnsBaseTest extends SanselanTest
{
    private static boolean isIcns(File file) throws IOException, ImageReadException
    {
        ImageFormat format = Sanselan.guessFormat(file);
        return format == ImageFormat.IMAGE_FORMAT_ICNS;
    }
    private static final ImageFilter IMAGE_FILTER = new ImageFilter() {
        public boolean accept(File file) throws IOException, ImageReadException
        {
            return isIcns(file);
        }
    };
    protected List getIcnsImages() throws IOException, ImageReadException
    {
        return getTestImages(IMAGE_FILTER);
    }
}