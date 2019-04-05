public class RowFriend extends RelativeLayout {
	private Context mContext;
	private String emailAddress;
	public RowFriend(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
	}
	public void setImage() {
		ImageView iv = (ImageView) findViewById(R.id.imgIcon);
		Util.getImageLoader(mContext).DisplayImage("http:	}
	public void setName(String name) {
		TextView tv = (TextView) findViewById(R.id.lblName);
		tv.setText(name);
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
}