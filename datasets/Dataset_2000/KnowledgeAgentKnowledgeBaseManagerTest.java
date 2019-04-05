public class KnowledgeAgentKnowledgeBaseManagerTest {
    @Test
    @Ignore
    public void testGetKnowledgeBase(){
        final KnowledgeAgentKnowledgeBaseManager kbaseManager = new KnowledgeAgentKnowledgeBaseManager();
        Assert.assertEquals(3, kbaseManager.getKnowledgeBase().getKnowledgePackages().size());
    }
}