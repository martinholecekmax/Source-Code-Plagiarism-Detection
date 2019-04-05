public abstract class OsmandListActivity extends ListActivity {
	@Override
	protected void onResume() {
		super.onResume();
		ListView view = getListView();
		view.setCacheColorHint(getResources().getColor(R.color.activity_background));
		view.setDivider(getResources().getDrawable(R.drawable.tab_text_separator));
	}
	protected OsmandApplication getMyApplication() {
		return (OsmandApplication) getApplication();
	}
}