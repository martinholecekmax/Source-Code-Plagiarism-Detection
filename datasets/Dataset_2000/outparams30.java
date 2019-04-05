public class outparams30 extends outparams {
	public static void takesBigDecimal(BigDecimal[] outparam, int type)
	{
		outparam[0] = (outparam[0] == null ? new BigDecimal("33") : outparam[0].add(outparam[0]));
		outparam[0].setScale(4, BigDecimal.ROUND_DOWN);
	}
	public static BigDecimal returnsBigDecimal(int type)
	{
		return new BigDecimal(666d);
	}
}