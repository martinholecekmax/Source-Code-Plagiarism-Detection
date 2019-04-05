public class MyState extends State {
	public MyState(Object stateId) {
		super(stateId);
	}
	@Override
	public void enterAction(Event event, Object context) {
		log.info("Do somthing..., context = " + context.toString());
	}
}