public class TestIntegralImagePerformance {
	public static void main(String[] args) {
		final int side = 2048;
		final float[] pix = new float[side * side];
		for (int i=0; i<pix.length; ++i) pix[i] = 1;
		final FloatProcessor fp = new FloatProcessor(side, side, pix, null);
		final FloatImage fii = new FloatImage(new long[]{side, side}, pix);
		for (int i=0; i<10; ++i) {
			long t0 = System.currentTimeMillis();
			DoubleIntegralImage dii = new DoubleIntegralImage(fp);
			FloatProcessor ip = new FloatProcessor(side, side);
			for (int y=0; y<ip.getHeight(); ++y){
				for (int x=0; x<ip.getWidth(); ++x){
					ip.setf(x, y, (float)dii.getDoubleSum(x,y));
				}
			}
			long t1 = System.currentTimeMillis();
			IntegralImage dig = new IntegralImage(fii); 			long t2 = System.currentTimeMillis();
			System.out.println("Saalfeld'ss: " + (t2 - t1) + " ms -- imglib2.script: " + (t1 - t0) + " ms");
			if (i == 1) {
				new ImageJ();
				try {
					new ImagePlus("Saalfeld's", ip).show();
					ImgLib.show(dig, "Mine");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}