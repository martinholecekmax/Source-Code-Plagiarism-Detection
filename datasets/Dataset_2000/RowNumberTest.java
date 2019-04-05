public class RowNumberTest {
    @Test
    public void Mutable() {
        RowNumber rn = rowNumber().orderBy(employee.firstname);
        assertEquals("row_number() over (order by e.FIRSTNAME)", rn.toString());
        assertEquals("row_number() over (order by e.FIRSTNAME, e.LASTNAME)", rn.orderBy(employee.lastname).toString());
    }
    @Test
    public void OrderBy() {
        assertEquals("row_number() over (order by e.FIRSTNAME)",
            rowNumber().orderBy(employee.firstname.asc()).toString());
        assertEquals("row_number() over (order by e.FIRSTNAME)",
            rowNumber().orderBy(employee.firstname).toString());
        assertEquals("row_number() over (order by e.FIRSTNAME) as rn",
            rowNumber().orderBy(employee.firstname.asc()).as(rn).toString());
        assertEquals("row_number() over (order by e.FIRSTNAME desc)",
            rowNumber().orderBy(employee.firstname.desc()).toString());
    }
    @Test
    public void PartitionBy() {
        assertEquals("row_number() over (partition by e.LASTNAME order by e.FIRSTNAME)",
            rowNumber().partitionBy(employee.lastname).orderBy(employee.firstname.asc()).toString());
        assertEquals("row_number() over (partition by e.LASTNAME, e.FIRSTNAME order by e.FIRSTNAME)",
            rowNumber().partitionBy(employee.lastname, employee.firstname).orderBy(employee.firstname.asc()).toString());        
    }
}