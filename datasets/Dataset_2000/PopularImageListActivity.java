public class PopularImageListActivity extends
		SingleFragmentActivity<ImageListFragment> implements
		ImageListFragment.Listener {
	@InjectDependency
	private ImageEntityManager imageEntityManager;
	private ImageListAdapter adapter;
	@Override
	protected ImageListFragment onCreateFragment() {
		return new ImageListFragment();
	}
	@Override
	protected void onStart() {
		super.onStart();
		setAdapter();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.options_image_list, menu);
		setReloadMenuItem(menu.findItem(R.id.menu_refresh));
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {
		case R.id.menu_refresh:
			setSupportProgressBarIndeterminateVisibility(true);
			intent = ImageIntentService.getUpdatePicsIntent(this,
					refreshResultReceiver);
			startService(intent);
			return true;
		case R.id.menu_settings:
			intent = SettingsActivity.getIntent(this);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	@Override
	public void onShowImageDetail(int position) {
		Image img = adapter.read(position);
		ImageDetailFragment.newInstance(img).show(this);
	}
	public void setAdapter() {
		adapter = new ImageListAdapter(this, imageEntityManager.select());
		getFragment().setContent(adapter);
	}
	private MainThreadResultReceiver refreshResultReceiver = new MainThreadResultReceiver() {
		protected void onReceiveResult(int resultCode, Bundle resultData) {
			setSupportProgressBarIndeterminateVisibility(false);
			setAdapter();
		}
	};
}