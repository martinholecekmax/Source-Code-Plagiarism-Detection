public class EvOpConvolve2D extends EvOpSlice1
	{
	private Number kcx;
	private Number kcy;
	private EvPixels kernel;
	public EvOpConvolve2D(EvPixels kernel, Number kcx, Number kcy)
		{
		this.kcx = kcx;
		this.kcy = kcy;
		this.kernel = kernel;
		}
	public EvPixels exec1(ProgressHandle ph, EvPixels... p)
		{
		return convolve(ph, p[0], kernel, kcx.intValue(), kcy.intValue());
		}
	public static EvPixels convolve(ProgressHandle ph, EvPixels in, EvPixels kernel, int kcx, int kcy)
		{
		in=in.getReadOnly(EvPixelsType.INT);
		kernel=kernel.getReadOnly(EvPixelsType.INT);
		int w=in.getWidth();
		int h=in.getHeight();
		int kw=kernel.getWidth();
		int kh=kernel.getHeight();
		EvPixels out=new EvPixels(in.getType(),w,h);
		int[] inPixels=in.getArrayInt();
		int[] kernelPixels=in.getArrayInt();
		int[] outPixels=out.getArrayInt();
						for(int ay=0;ay<h;ay++)
			for(int ax=0;ax<w;ax++)
				{
								int fromx=Math.max(-kcx,-ax);
				int tox=Math.min(kw-kcx,w-(kw-kcx));
				int fromy=Math.max(-kcy,-ay);
				int toy=Math.min(kh-kcy,h-(kh-kcy));
								int sum=0;
				for(int kx=fromx;kx<tox;kx++)
					for(int ky=fromy;ky<toy;ky++)
						sum+=inPixels[in.getPixelIndex(ax+kx, ay+ky)]*kernelPixels[kernel.getPixelIndex(kcx+kx, kcy+ky)];
				outPixels[out.getPixelIndex(ax, ay)]=sum;
				}
		return out;
		}
	
	}