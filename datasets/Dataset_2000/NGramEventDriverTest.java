public class NGramEventDriverTest {
	@Test
	public void testCreateEventSetDocumentSet() throws EventGenerationException {
		Document doc = new Document();
		doc.readStringText("Testing sentence. My name is Joe. run jump, game-start?  Hello!");
		EventSet sampleEventSet = new NGramEventDriver().createEventSet(doc);
		EventSet expectedEventSet = new EventSet();
		Vector<Event> tmp = new Vector<Event>();
		tmp.add(new Event("(Testing)-(sentence.)"));
		tmp.add(new Event("(sentence.)-(My)"));
		tmp.add(new Event("(My)-(name)"));
		tmp.add(new Event("(name)-(is)"));
		tmp.add(new Event("(is)-(Joe.)"));
		tmp.add(new Event("(Joe.)-(run)"));
		tmp.add(new Event("(run)-(jump,)"));
		tmp.add(new Event("(jump,)-(game-start?)"));
		tmp.add(new Event("(game-start?)-(Hello!)"));
		expectedEventSet.addEvents(tmp);
		assertTrue(expectedEventSet.equals(sampleEventSet));
	}
}