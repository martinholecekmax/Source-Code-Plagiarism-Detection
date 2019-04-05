public final class SubtractComposite extends RGBComposite {
	public SubtractComposite( float alpha ) {
        super( alpha );
	}
	public CompositeContext createContext( ColorModel srcColorModel, ColorModel dstColorModel, RenderingHints hints ) {
		return new Context( extraAlpha, srcColorModel, dstColorModel );
	}
    static class Context extends RGBCompositeContext {
        public Context( float alpha, ColorModel srcColorModel, ColorModel dstColorModel ) {
            super( alpha, srcColorModel, dstColorModel );
        }
        public void composeRGB( int[] src, int[] dst, float alpha ) {
            int w = src.length;
            for ( int i = 0; i < w; i += 4 ) {
                int sr = src[i];
                int dir = dst[i];
                int sg = src[i+1];
                int dig = dst[i+1];
                int sb = src[i+2];
                int dib = dst[i+2];
                int sa = src[i+3];
                int dia = dst[i+3];
                int dor, dog, dob;
                dor = dir - sr;
                if ( dor < 0 )
                    dor = 0;
                dog = dig - sg;
                if ( dog < 0 )
                    dog = 0;
                dob = dib - sb;
                if ( dob < 0 )
                    dob = 0;
                float a = alpha*sa/255f;
                float ac = 1-a;
                dst[i] = (int)(a*dor + ac*dir);
                dst[i+1] = (int)(a*dog + ac*dig);
                dst[i+2] = (int)(a*dob + ac*dib);
                dst[i+3] = (int)(sa*alpha + dia*ac);
            }
        }
    }
}