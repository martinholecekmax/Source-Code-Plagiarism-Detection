public class SimpleMTExample {
    
    @Test
    public void testWithMultipleThread() {
                Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();
        Scenario scenario12 = new Scenario() {
            {
                            }
        };
        Stubs stubs23 = new Stubs() {
            {
                            }
        };
        Actor actor1 = anActorForThread(thread1).following(scenario12);
        Actor actor2 = anActorForThread(thread2).following(scenario12).using(stubs23);
        Actor actor3 = anActorForThread(thread3).using(stubs23);
        Story story = Story.create(actor1, actor2, actor3);
        story.begin();
                story.end();
    }
}