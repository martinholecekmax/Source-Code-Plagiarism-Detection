@SuppressWarnings("serial")
public class TestEmpty extends PApplet {
	Laserschein laser;
	public void setup() {
		size(400, 400, P3D);
		frameRate(-1); 		smooth();
		laser = new Laserschein(this,Laserschein.EASYLASEUSB2);
	}
	public void draw() {
		background(60);
		Laser3D renderer = laser.renderer();
		beginRaw(renderer);
		stroke(0,0,255);
		translate(mouseX, mouseY);
		noFill(); 		renderer.noSmooth();
		laser.output().setScanSpeed(40000);
		println(laser.output().getScanSpeed());
		rectMode(CENTER);
		rect(0,0,width*0.1f, height*0.1f);
														endRaw();
	}
	public static void main(String[] args) {
		PApplet.main(new String[] { TestEmpty.class.getCanonicalName() });
	}
}