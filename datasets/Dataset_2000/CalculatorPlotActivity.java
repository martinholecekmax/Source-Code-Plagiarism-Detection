public class CalculatorPlotActivity extends CalculatorFragmentActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        final Bundle arguments;
        if (intent != null) {
            arguments = intent.getExtras();
        } else {
            arguments = null;
        }
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        getActivityHelper().setFragment(this, CalculatorFragmentType.plotter, arguments, R.id.main_layout);
    }
}