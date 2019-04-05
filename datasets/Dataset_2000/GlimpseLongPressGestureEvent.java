public class GlimpseLongPressGestureEvent extends GlimpseGestureEvent
{
    protected String source;
    protected GlimpseTargetStack stack;
    protected float x;
    protected float y;
    public GlimpseLongPressGestureEvent( String source, GlimpseTargetStack stack, float x, float y )
    {
        this.source = source;
        this.stack = stack;
        this.x = x;
        this.y = y;
    }
    public String getSource( )
    {
        return source;
    }
    public float getX( )
    {
        return x;
    }
    public float getY( )
    {
        return y;
    }
    public GlimpseTargetStack getTargetStack( )
    {
        return this.stack;
    }
    public Axis1D getAxis1D( )
    {
        GlimpseTargetStack stack = getTargetStack( );
        GlimpseTarget target = stack.getTarget( );
        if ( target instanceof GlimpseAxisLayout1D )
        {
            GlimpseAxisLayout1D layout = ( GlimpseAxisLayout1D ) target;
            return layout.getAxis( stack );
        }
        else
        {
            return null;
        }
    }
    public Axis2D getAxis2D( )
    {
        GlimpseTargetStack stack = getTargetStack( );
        GlimpseTarget target = stack.getTarget( );
        if ( target instanceof GlimpseAxisLayout2D )
        {
            GlimpseAxisLayout2D layout = ( GlimpseAxisLayout2D ) target;
            return layout.getAxis( stack );
        }
        else
        {
            return null;
        }
    }
    @Override
    public String toString( )
    {
        return String.format( "x: %f y: %f", x, y );
    }
}