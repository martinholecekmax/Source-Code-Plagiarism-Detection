public class ReportProblemHandler extends AbstractHandler implements IHandler {
    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final PreferenceDialog dlg = PreferencesUtil.createPreferenceDialogOn(
                null, "org.erlide.ui.reporting", null, null);
        dlg.open();
        return null;
    }
}