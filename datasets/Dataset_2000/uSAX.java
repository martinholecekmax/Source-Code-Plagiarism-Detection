public class uSAX extends UndocumentedInstruction {
	public uSAX(M6502 cpu, OperandType type) {
		super(cpu);
		this.type = type;
	}
	@Override
	public int fetch() {
		switch (type) {
			case Z_PAGE:
				ea = cpu.fetchZeroPageAddress(); return 3;
			case Z_PAGE_Y:
				ea = cpu.fetchZeroPageXAddress(); return 4;
			case IND_X:
				ea = cpu.fetchZeroPageXAddress(); return 6;
			case ABS:
				ea = cpu.fetchAbsoluteAddress(); return 4;
			default:
				throw new IllegalStateException("uAAX Invalid Operand Type: " + type);
		}
	}
	@Override
		public void execute() {
		final byte val = (byte) (cpu.A & cpu.X);
		cpu.memory.writeByte(ea, val);
	}
	private final OperandType type;
	private int ea;
	public static final long serialVersionUID = 1L;
}