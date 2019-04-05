public class MapFileWriter
{
	private CsvFileWriter writer;
	public MapFileWriter(File mapFile) throws Exception
	{
		writer = new CsvFileWriter(mapFile);
		writer.setHeaders(MapEntry.mapHeader());
		writer.setSeparator(" ");
	}
	
	public void close(){
		writer.close();
	}
	
	public void writeSingle(MapEntry map){
		writer.writeRow(MapEntry.mapToTuple(map));
	}
	
	public void writeMulti(List<MapEntry> maps){
		for(MapEntry map : maps){
			writer.writeRow(MapEntry.mapToTuple(map));
		}
	}
	
	public void writeAll(List<MapEntry> maps){
		for(MapEntry map : maps){
			writer.writeRow(MapEntry.mapToTuple(map));
		}
		writer.close();
	}
}