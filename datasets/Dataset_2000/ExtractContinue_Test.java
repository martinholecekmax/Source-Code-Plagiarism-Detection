@MPSLaunch
public class ExtractContinue_Test extends BaseTransformationTest4 {
  @Test
  public void test_ExtractContinue() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.ExtractContinue_Test$TestBody", "test_ExtractContinue", true);
  }
  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_ExtractContinue() throws Exception {
      this.addNodeById("1230052480439");
      this.addNodeById("1230052480459");
      ExtractMethodRefactoringParameters params = ExtractMethodFactory.createParameters(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052480448"), "jetbrains.mps.baseLanguage.structure.IfStatement")));
      params.setName("foo");
      ExtractMethodRefactoring ref = ExtractMethodFactory.createRefactoring(params);
      Assert.assertTrue(ref instanceof ExtractMethodWithExitPoints);
      ref.doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052480440"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052480460"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}