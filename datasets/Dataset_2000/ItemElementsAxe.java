public class ItemElementsAxe extends ItemElementsTool
implements ITextureProvider
{
	@Override
	public String getTextureFile() 
	{
		return "/elements/Items/EModItems.png";
	}
    private static Block blocksEffectiveAgainst[];
    protected ItemElementsAxe(int i, EnumElementsToolMaterial enumelementstoolmaterial)
    {
        super(i, 3, enumelementstoolmaterial, blocksEffectiveAgainst);
    }
    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        if(block != null && block.blockMaterial == Material.wood)
        {
            return efficiencyOnProperMaterial;
        } else
        {
            return super.getStrVsBlock(itemstack, block);
        }
    }
    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stairDouble, Block.stairSingle, Block.pumpkin, Block.pumpkinLantern
        });
    }
}