public class ListCorpusByNameDaoHelper extends ParameterizedSingleColumnRowMapper<Long>
{
  public String createSql(List<String> corpusNames)
  {
    Validate.notEmpty(corpusNames, "Need at least one corpus name");
        List<String> corpusNamesSqlStrings = new ArrayList<String>();
    for (String corpus : corpusNames)
    {
      corpusNamesSqlStrings.add(sqlString(corpus));
    }
        StringBuilder sb = new StringBuilder();
    sb.append("SELECT id FROM corpus WHERE name IN ( ");
    sb.append(StringUtils.join(corpusNamesSqlStrings, ", "));
    sb.append(" ) AND top_level = 't'");
    return sb.toString();
  }
}