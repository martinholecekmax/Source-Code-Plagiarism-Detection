public class HBaseRestDeleter {
	public static void main(String[] args) throws IOException{
		deleteRowFromHBase("localhost", 8080, "test","row3");
	}
	public static void deleteRowFromHBase(String remoteHost, int remotePort, String remoteTable, String rowToDelete) throws IOException{
		RemoteHTable table = new RemoteHTable(
        		new Client(
        				new Cluster().add(remoteHost, remotePort)
        		), remoteTable
        	);
		byte[] row3 = Bytes.toBytes(rowToDelete);
        table.delete(new Delete(row3));
	}
	public static void deleteRowFromHBase(String remoteHost, int remotePort, String remoteTable, List<String> rowsToDelete) throws IOException{
		RemoteHTable table = new RemoteHTable(
        		new Client(
        				new Cluster().add(remoteHost, remotePort)
        		), remoteTable
        	);
		ArrayList<byte[]> rowBytes = new ArrayList<byte[]>();
		for(String s : rowsToDelete){
			rowBytes.add(Bytes.toBytes(s));
		}
		for(byte[] b : rowBytes){
			table.delete(new Delete(b));
		}
	}	
}