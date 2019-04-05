@EActivity(R.layout.main)
public class CustomFrameLayoutActivity extends Activity {
	private CustomFrameLayout layout;
	@AfterViews
	public void afterViews(){
		layout = CustomFrameLayout_.build(this, 2);
		layout.tv.setText("Plop");
	}
}