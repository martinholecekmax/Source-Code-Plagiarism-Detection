public class StatisticsToolView extends AbstractStatisticsToolView {
    public static final String ID = StatisticsToolView.class.getName();
    @Override
    protected PagePanel createPagePanel() {
        return new StatisticsPanel(this, getDescriptor().getHelpId());
    }
}