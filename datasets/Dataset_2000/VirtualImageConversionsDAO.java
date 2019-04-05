public interface VirtualImageConversionsDAO extends DAO<VirtualImageConversionsHB, Integer>
{
        public void saveConversions(Collection<VirtualImageConversionsHB> conversions)
        throws PersistenceException;
    public Collection<VirtualImageConversionsHB> getConversion(VirtualimageHB image,
        DiskFormatType diskFormat);
    public Collection<VirtualImageConversionsHB> getFinishedConversion(VirtualimageHB image,
        DiskFormatType diskFormat);
    public VirtualImageConversionsHB getUnbundledConversion(VirtualimageHB image,
        DiskFormatType diskFormat);
    public boolean isConverted(VirtualimageHB image);
    public boolean isConverted(VirtualimageHB image, DiskFormatType targetType);
    public Collection<VirtualImageConversionsHB> getConversions(Collection<Integer> imageIds);
}