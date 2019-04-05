@SuppressWarnings({"unchecked"})
public class PyramidUpdateSubsampleScale< T extends ImageSingleBand>
		implements PyramidUpdaterFloat<T> {
		protected InterpolatePixel<T> interpolate;
	public PyramidUpdateSubsampleScale(InterpolatePixel<T> interpolate) {
		this.interpolate = interpolate;
	}
	@Override
	public void update(T input, PyramidFloat<T> pyramid) {
		if( !pyramid.isInitialized() )
			pyramid.initialize(input.width,input.height);
		if( pyramid.isSaveOriginalReference() )
			throw new IllegalArgumentException("The original reference cannot be saved");
		for( int i = 0; i < pyramid.scale.length; i++ ) {
			T prev = i == 0 ? input : pyramid.getLayer(i-1);
			T layer = pyramid.getLayer(i);
			float s;
			if( i > 0 )
				s = (float)(pyramid.scale[i]/pyramid.scale[i-1]);
			else
				s = (float)pyramid.scale[0];
			PixelTransformAffine_F32 model = DistortSupport.transformScale(layer,prev);
			DistortImageOps.distortSingle(prev,layer,model,null,interpolate);
		}
	}
}