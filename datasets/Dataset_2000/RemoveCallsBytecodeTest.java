public class RemoveCallsBytecodeTest extends BaseBytecodeTest {
	private Class<?> clazz;
	public RemoveCallsBytecodeTest() throws Exception {
		super(RemoveCallsTEMPLATE.class);
		clazz = prepareTest();
	}
	@Test
	public void testM1() throws Exception {
		Method m1 = clazz.getMethod("m1");
		checkUnmutated(23, m1, clazz);
		checkMutation(7, MutationType.REMOVE_CALL, 0, new Object[0], 5, m1,
				clazz);
	}
	@Test
	public void testM2() throws Exception {
		Method m2 = clazz.getMethod("m2", int.class);
		checkUnmutated(2, 23, m2, clazz);
		checkUnmutated(0, 5, m2, clazz);
		checkMutation(19, MutationType.REMOVE_CALL, 0, 2, 5, m2, clazz);
		checkMutation(19, MutationType.REMOVE_CALL, 0, 0, 5, m2, clazz);
	}
	@Test
	public void testM3() throws Exception {
		Method m2 = clazz.getMethod("m3");
		checkUnmutated(23, m2, clazz);
		checkMutation(34, MutationType.REMOVE_CALL, 0, 5, m2, clazz);
	}
	@Test
	public void testM4() throws Exception {
		Method m4 = clazz.getMethod("m4");
		checkUnmutated(23, m4, clazz);
		checkMutation(47, MutationType.REMOVE_CALL, 0, 23, m4, clazz);
	}
}