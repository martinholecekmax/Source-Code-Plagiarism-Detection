public class ImageBank {
	private static Texture boxTex;
	public static void texInit(){
		try {
			boxTex = TextureLoader.getTexture("BMP", new FileInputStream("crate.bmp"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not load texture");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Texture getBoxTex(){
		return boxTex;
	}
}