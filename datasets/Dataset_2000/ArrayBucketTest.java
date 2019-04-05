public class ArrayBucketTest extends BucketTestBase {
	public ArrayBucketFactory abf = new ArrayBucketFactory();
	@Override
	protected Bucket makeBucket(long size) throws IOException {
		return abf.makeBucket(size);
	}
	@Override
	protected void freeBucket(Bucket bucket) throws IOException {
		bucket.free();
	}
}