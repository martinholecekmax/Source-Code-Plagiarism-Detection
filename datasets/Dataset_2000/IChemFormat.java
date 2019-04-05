public interface IChemFormat extends IResourceFormat {
    
    public String getReaderClassName();
    
    public String getWriterClassName();
    
	public int getSupportedDataFeatures();
    
    public int getRequiredDataFeatures();
}