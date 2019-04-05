public class ItemDebugStick extends multiItem {
    public ItemDebugStick(int par1, String name) {
        super(par1, name);
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    @DebugStatementInThisMethod
    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        core.print("ID: " + world.getBlockId(x, y, z));
        core.print("Meta: " + world.getBlockMetadata(x, y, z));
        world.setBlockMetadata(x, y, z, world.getBlockMetadata(x, y, z) + 6);
        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }
    public static class Debug {
        public static ItemIDManager id;
        public static ItemDebugStick debug;
        public static void create(){
            id = new ItemIDManager(1,"DebugStick");
            core.PfFCore.config.addDefault("DebugStick_ItemID=" + id.getItemIDs().get(0));
            int itemID = core.PfFCore.config.getOptionInt("DebugStick_ItemID");
            debug = new ItemDebugStick(itemID,"debugstick");
            debug.metaMap.put("Debug Stick",0);
            debug.add("debugstick", 0, EnumToolTextures.ToolTextures.DEBUGSTICK.getIndex(), "Debug Stick");
        }
    }
}