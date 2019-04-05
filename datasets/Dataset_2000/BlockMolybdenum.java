public class BlockMolybdenum extends Block
implements ITextureProvider
{
    public String getTextureFile()
    {
		return "/elements/Blocks/EModBlocks.png";
    }
	public BlockMolybdenum(int i, int j)
	{
		super(i, j, Material.rock);
	}
}