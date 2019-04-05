public class DepartmentTermTest extends TestCase {
    DepartmentTerm dep;
    public void setUp() {
        dep = new DepartmentTerm(1);
    }
    public void testDepartmentTerm() {
        String clause = "Article.refsection = 1";
        assertEquals(clause, dep.whereClause());
    }
    public void testGetTables() {
        String tables[] = {"Article"};
        assertEquals(tables[0], dep.getTables()[0]);
    }
}