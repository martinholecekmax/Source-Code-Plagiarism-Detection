public class TestFnvHash extends EvalHash {
    public TestFnvHash() {
        super(TestFnvHash.class.getSimpleName());
    }
    @Override
    protected HashFunction<byte[]> createHashFunction() {
        return new FnvHashFunction();
    }
}