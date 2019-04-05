public class MIGDBSetSysroot extends MIGDBSet 
{
	public MIGDBSetSysroot(ICommandControlDMContext ctx, String path) {
		super(ctx, new String[] {"sysroot", path});	}
		public MIGDBSetSysroot(ICommandControlDMContext ctx) {
		this(ctx, "/dev/null"); 	}
}