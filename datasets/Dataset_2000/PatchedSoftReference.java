public class PatchedSoftReference<T> extends SoftReference<T> {
  public PatchedSoftReference(final T referent) {
    super(referent);
  }
  public PatchedSoftReference(final T referent, final ReferenceQueue<? super T> q) {
    super(referent, q);
  }
}