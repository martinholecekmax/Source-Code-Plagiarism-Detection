public class GanttImpl extends ValueSeriesImpl implements IGantt
{
	public GanttImpl( SeriesDefinition sd, Chart cm )
	{
		super( sd, cm );
		assert series instanceof GanttSeries;
	}
	public ISeriesData getDataExpr( )
	{
		return new GanttDataImpl( sd );
	}
}