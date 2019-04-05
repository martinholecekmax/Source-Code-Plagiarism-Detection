public class TestPerson386 {
  @Test
  public void testPerson() {
      Person p = new Person();
      p.setAge(20);
      p.setName("Fird Birfle");
      p.setSalary(195750.22);
      assertEquals(215325.242, p.calculateBonus(), 0.01);
      assertEquals("The Honorable Fird Birfle", p.becomeJudge());
      assertEquals(30, p.timeWarp());
      p.wasteTime();
  }
}