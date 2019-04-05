public class abcURLContextFactory implements ObjectFactory {
	
	public Object getObjectInstance(Object o, Name n, Context c, Hashtable<?, ?> h)
			throws Exception {
		NamingManagerTest.issueIndicatedExceptions(h);
		if (NamingManagerTest.returnNullIndicated(h)) {
			return null;
		}
		Hashtable<String, Object> r = new Hashtable<String, Object>();
		if (null != o) {
			r.put("o", o);
		}
		if (null != n) {
			r.put("n", n);
		}
		if (null != c) {
			r.put("c", c);
		}
		if (null != h) {
			r.put("h", h);
		}
		r.put("url.schema", "abc");
		return new MockDirContext(r);
	}
}