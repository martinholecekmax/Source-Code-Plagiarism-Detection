public class SumLogTest extends StorelessUnivariateStatisticAbstractTest{
    protected SumOfLogs stat;
    
    public SumLogTest(String name) {
        super(name);
    }
    
    @Override
    public UnivariateStatistic getUnivariateStatistic() {
        return new SumOfLogs();
    }
    
    @Override
    public double expectedValue() {
        return this.sumLog;
    }
    public void testSpecialValues() {
        SumOfLogs sum = new SumOfLogs();
                assertTrue(Double.isNaN(sum.getResult()));
                sum.increment(1d);
        assertFalse(Double.isNaN(sum.getResult()));
                sum.increment(0d);
        assertEquals(Double.NEGATIVE_INFINITY, sum.getResult(), 0);
                sum.increment(Double.POSITIVE_INFINITY);
        assertTrue(Double.isNaN(sum.getResult()));
                sum.clear();
        assertTrue(Double.isNaN(sum.getResult()));
                sum.increment(Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, sum.getResult(), 0);
                sum.increment(-2d);
        assertTrue(Double.isNaN(sum.getResult()));
    }
}