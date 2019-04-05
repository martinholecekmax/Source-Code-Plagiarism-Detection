class A {
	
	public void m(int i, String... names) {
		m(new Object(), i, names);
	}
	public void m(Object o, int i, String... names) {
		for (String name : names) {
			System.out.println(name);
		}
	}
}
class B extends A {
	
	public void m(int i, String[] names) {
		m(new Object(), i, names);
	}
	public void m(Object o, int i, String[] names) {
		for (String name : names) {
			System.out.println(name);
		}
	}
}
class Client {
	{
		new A().m(new Object(), 0);
		new A().m(new Object(), 2, "X", "Y", "Z");
		new B().m(new Object(), 1, new String[] {"X"});
	}
}