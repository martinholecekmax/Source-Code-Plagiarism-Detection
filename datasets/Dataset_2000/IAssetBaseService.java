public interface IAssetBaseService extends IEntityService<AssetBase> {
    public AssetBase findByCode(String code);
    public List<AssetBase> findByOrg(Organization org);
    public List<AssetBase> findByOrgId(Long orgId);
    public List<AssetBase> findByProduct(Product product);
    public List<AssetBase> findByProductId(Long productId);
}