public class ScenarioRenameShuffle implements Scenario
{
    private static Log logger = LogFactory.getLog(ScenarioRenameShuffle.class);
    
    private Pattern pattern;
    private String strPattern;
    private long timeout = 30000;
    @Override
    public ScenarioInstance createInstance(final EvaluatorContext ctx, Operation operation)
    {
        
        if(operation instanceof RenameFileOperation)
        {          
            RenameFileOperation r = (RenameFileOperation)operation;
            Matcher m = pattern.matcher(r.getTo());
            if(m.matches())
            {
                if(logger.isDebugEnabled())
                {
                    logger.debug("New Scenario Rename Shuffle Instance strPattern:" + pattern);
                }
                ScenarioRenameShuffleInstance instance = new ScenarioRenameShuffleInstance();
                instance.setTimeout(timeout);
                instance.setRanking(ranking);
                return instance;
            }
        }
                return null;
    }
    public void setTimeout(long timeout)
    {
        this.timeout = timeout;
    }
    public long getTimeout()
    {
        return timeout;
    }
    public void setPattern(String pattern)
    {
        this.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        this.strPattern = pattern;
    }
    public String getPattern()
    {
        return strPattern;
    }    
    private Ranking ranking = Ranking.HIGH;
    public void setRanking(Ranking ranking)
    {
        this.ranking = ranking;
    }
    public Ranking getRanking()
    {
        return ranking;
    }
}