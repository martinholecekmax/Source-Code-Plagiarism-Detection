public interface IProviderDAO {
	public int getRecordCountByUploadId(int uploadId);
	
	public void createTempTable(String tempProviderTableName)
			throws I2B2Exception;
	
	public TempProviderInsertHandler createTempProviderInsert(
			String tempTableName);
	
	public void createProviderFromTempTable(String tempProviderTableName,
			int uploadId) throws I2B2Exception;
	
	public void backupAndSyncProviderDimensionTable(
			String tempConceptTableName,
			String backupProviderDimensionTableName, int uploadId)
			throws I2B2Exception;
}