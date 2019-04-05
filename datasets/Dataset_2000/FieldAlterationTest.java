public class FieldAlterationTest {
	public static class Cmd1 {
		@In
		public String in1;
		@Out
		public double out1;
		@Execute
		public void execute() {
			out1 = 1.2;
		}
	}
	public static class Cmd2 {
		@In
		public double in2;
		@Out
		public String out2;
		@Execute
		public void whatever() {
			out2 = "CMD2(" + in2 + ")";
		}
	}
	public static class C extends Compound {
		@In
		public String in;
		@Out
		public String out;
				Cmd1 op1 = new Cmd1();
		Cmd2 op2 = new Cmd2();
		public C() {
						out2in(op1, "out1", op2, "in2");
						in2in("in", op1, "in1");
			out2out("out", op2, "out2");
		}
	}
	@BeforeClass
	public static void setUpBeforeClass() {
		Compound.reload();
	}
	@Test(timeout = 700)
	public void alterOutput() throws Exception {
		C c = new C();
		c.addListener(new Listener() {
			@Override
			public void notice(Type T, EventObject E) {
				if (T == Type.OUT) {
					DataflowEvent ce = (DataflowEvent) E;
					if (ce.getValue() instanceof Double) {
						assertEquals(1.2, ce.getValue());
						ce.setValue(new Double(3.2));
					}
														}
			}
		});
		c.in = "1";
		c.execute();
				assertEquals("CMD2(3.2)", c.out);
	}
}