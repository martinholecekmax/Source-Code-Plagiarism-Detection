public class SetMaxRows extends Command {
    private final int max;
    public SetMaxRows(int max) {
        this.max = max;
    }
    @Override
    public void apply(PepePreparedStatement ps) throws SQLException {
        ps.setMaxRows(max);
    }
}