public class ViewEventHandlerActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(SourceConstants.VIEW_EVENT_INTENT.equals(getIntent().getAction())) {
						Intent intent = new Intent();
			intent.setAction(Intent.ACTION_DIAL);
			startActivity(intent);
		} 
		finish();
	}
}