public class RhymestoreApplication extends GDApplication
{
    @Override
    public Class< ? > getHomeActivityClass()
    {
        return HomeActivity.class;
    }
    @Override
    public Intent getMainApplicationIntent()
    {
        return null;
                    }
}