public class BlockIceWood extends Block {
	public BlockIceWood(int i, int j) {
		super(i, j, Material.rock);
		this.setTickRandomly(true);
		setRequiresSelfNotify();
	}
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		return getBlockTextureFromSide(i);
	}
	public int getBlockTextureFromSide(int i) {
		if (i == 0 || i == 1) {
			return 0x0c;
		} else {
			return 0x2c;
		}
	}
	public void updateTick(World world, int i, int j, int k, Random random) {
		for (int di = -3; di < 3; di++) {
			for (int dj = -3; dj < 3; dj++) {
				for (int dk = -3; dk < 3; dk++) {
										int b = world.getBlockId(i + di, j + dj, k + dk);
					if (b == 8 || b == 9) {
						world.setBlockAndMetadataWithNotify(i + di, j + dj, k
								+ dk, 79, 1);
					}
					if (b == 11) {
						world.setBlockAndMetadataWithNotify(i + di, j + dj, k
								+ dk, 49, 1);
					}
					if (b == 10) {
						world.setBlockAndMetadataWithNotify(i + di, j + dj, k
								+ dk, 4, 1);
					}
					if (b == 51 || b == 50) {
						world.setBlockAndMetadataWithNotify(i + di, j + dj, k
								+ dk, 0, 1);
					}
				}
			}
		}
	}
	@Override
	public String getTextureFile() {
		return CommonProxy.BLOCK_PNG;
	}
}