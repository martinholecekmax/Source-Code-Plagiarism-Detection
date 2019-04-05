public class NullStoryReporter implements StoryReporter {
    public void beforeStep(String step) {
    }
    public void successful(String step) {
    }
    public void ignorable(String step) {
    }
    public void pending(String step) {
    }
    public void notPerformed(String step) {
    }
    public void failed(String step, Throwable cause) {
    }
    public void failedOutcomes(String step, OutcomesTable table) {
    }
    public void storyNotAllowed(Story story, String filter) {
    }
    public void beforeStory(Story story, boolean givenStory) {
    }
    public void storyCancelled(Story story, StoryDuration storyDuration) {
    }
    public void afterStory(boolean givenStory) {
    }
    public void narrative(final Narrative narrative) {
    }
    public void givenStories(GivenStories givenStories) {
    }
    public void givenStories(List<String> storyPaths) {
    }
    public void beforeScenario(String title) {
    }
    public void scenarioNotAllowed(Scenario scenario, String filter) {
    }
    public void scenarioMeta(Meta meta) {
    }
    public void afterScenario() {
    }
    public void beforeExamples(List<String> steps, ExamplesTable table) {
    }
    public void example(Map<String, String> tableRow) {
    }
    public void afterExamples() {
    }
    public void dryRun() {
    }
    public void pendingMethods(List<String> methods) {
    }
    public void restarted(String step, Throwable cause) {
    }
}