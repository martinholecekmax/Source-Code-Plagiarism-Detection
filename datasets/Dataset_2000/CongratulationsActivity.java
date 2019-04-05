public class CongratulationsActivity extends PreyActivity {
	private static final int SECURITY_PRIVILEGES = 10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	protected void onResume() {
		super.onResume();
		if (getPreyConfig().isFroyoOrAbove() && !FroyoSupport.getInstance(this).isAdminActive()){
			PreyLogger.i("Is froyo or above!!");
			Intent intent = FroyoSupport.getInstance(getApplicationContext()).getAskForAdminPrivilegesIntent();
			startActivityForResult(intent, SECURITY_PRIVILEGES);
		} else {
			showScreen();
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == SECURITY_PRIVILEGES)
			showScreen();
	}
	private void showScreen(){
		setContentView(R.layout.congratulations);
		Bundle bundle = getIntent().getExtras();
		((TextView) findViewById(R.id.congrats_h2_text)).setText(bundle.getString("message"));
		getPreyConfig().registerC2dm();
		Button ok = (Button) findViewById(R.id.congrats_btn_ok);
		ok.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(CongratulationsActivity.this, PreyConfigurationActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}