public class Plasma2 extends Generator {
	
	private int frameCount;
	
	public Plasma2(PixelControllerGenerator controller) {
		super(controller, GeneratorName.PLASMA, ResizeName.QUALITY_RESIZE);
		frameCount=1;
	}
	
	@Override
	public void update() {
		float  xc = 20;
								int timeDisplacement = frameCount++;
				float calculation1 = (float)Math.sin( PApplet.radians(timeDisplacement * 0.61655617f));
		float calculation2 = (float)Math.sin( PApplet.radians(timeDisplacement * -3.6352262f));
		int aaa = 1024;
		int ySize = internalBufferYSize;
				for (int x = 0; x < internalBufferXSize; x++, xc++) {
			float yc = 20;
			float s1 = aaa + aaa * (float)Math.sin(PApplet.radians(xc) * calculation1 );
			for (int y = 0; y < ySize; y++, yc++) {
				float s2 = aaa + aaa * (float)Math.sin(PApplet.radians(yc) * calculation2 );
				float s3 = aaa + aaa * (float)Math.sin(PApplet.radians((xc + yc + timeDisplacement * 5) / 2));  
				float s  = (s1+ s2 + s3) / (6f*255f);
				this.internalBuffer[y*internalBufferXSize+x] = (int)(s*255);
			}
		}   
	}
}