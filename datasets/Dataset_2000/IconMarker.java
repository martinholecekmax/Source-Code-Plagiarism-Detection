public class IconMarker {
	private ImageIcon _image;
	private int _pX;
	private int _pY;
	private long _id;
	private static long _next = 1;
	public IconMarker(ImageIcon image, int pX, int pY) {
		super();
		_id = _next;
		_next = _next * 2;
		this._image = image;
		this._pX = pX;
		this._pY = pY;
	}
	public int getPX() {
		return _pX;
	}
	public int getPY() {
		return _pY;
	}
	public ImageIcon getImage() {
		return _image;
	}
	public long getID() {
		return _id;
	}
	public IconMarker clone(int x, int y) {
		return new IconMarker(_image, x, y);
	}
}