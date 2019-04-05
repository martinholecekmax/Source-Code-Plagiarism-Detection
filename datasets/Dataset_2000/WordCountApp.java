public class WordCountApp extends App {
    protected boolean checkpointing = false;
    @Inject
    public WordCountApp() {
        super();
    }
    @Override
    protected void onStart() {
            }
    @Override
    protected void onInit() {
        WordClassifierPE wordClassifierPrototype = createPE(WordClassifierPE.class, "classifierPE");
        Stream<WordCountEvent> wordCountStream = createStream("words counts stream", new WordCountKeyFinder(),
                wordClassifierPrototype);
        WordCounterPE wordCounterPrototype = createPE(WordCounterPE.class, "counterPE");
                wordCounterPrototype.setWordClassifierStream(wordCountStream);
        Stream<WordSeenEvent> wordSeenStream = createStream("words seen stream", new WordSeenKeyFinder(),
                wordCounterPrototype);
        WordSplitterPE wordSplitterPrototype = createPE(WordSplitterPE.class);
        wordSplitterPrototype.setWordSeenStream(wordSeenStream);
        Stream<Event> sentenceStream = createInputStream("inputStream", new SentenceKeyFinder(), wordSplitterPrototype);
    }
    @Override
    protected void onClose() {
    }
}