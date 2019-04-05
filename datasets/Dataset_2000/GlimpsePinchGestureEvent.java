public class GlimpsePinchGestureEvent extends GlimpseGestureEvent
{
    protected String source;
    protected GlimpseTargetStack stack;
    protected float xCenterPixel;
    protected float yCenterPixel;
    protected float scale;
    public GlimpsePinchGestureEvent( String source, GlimpseTargetStack stack, float xCenterPixel, float yCenterPixel, float scale )
    {
        this.source = source;
        this.stack = stack;
        this.xCenterPixel = xCenterPixel;
        this.yCenterPixel = yCenterPixel;
        this.scale = scale;
    }
    public String getSource( )
    {
        return source;
    }
    public float getScale( )
    {
        return scale;
    }
    public float getCenterPixelX( )
    {
        return xCenterPixel;
    }
    public float getCenterPixelY( )
    {
        return yCenterPixel;
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
        return String.format( "x: %f y: %f scale: %f ", xCenterPixel, yCenterPixel, scale );
    }
}