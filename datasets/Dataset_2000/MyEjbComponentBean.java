public class MyEjbComponentBean implements MyEjbComponent {
	private String testInjection;
	private Queue<?> queue;
	@Override
	public String doSomething() {
		return "Hello World";
	}
	public String getTestInjection() {
		return testInjection;
	}
	public Queue<?> getQueue() {
    	return queue;
    }
}