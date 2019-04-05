public class CustomJob extends AbstractJob
{
    protected void doExecute(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        Object tempJob = jobDataMap.get(QuartzConnector.PROPERTY_JOB_OBJECT);
        if (tempJob == null)
        {
            tempJob = jobDataMap.get(QuartzConnector.PROPERTY_JOB_REF);
            if (tempJob == null)
            {
                throw new JobExecutionException(QuartzMessages.invalidPayloadType().getMessage());
            }
            else
            {
                tempJob = muleContext.getRegistry().lookupObject((String) tempJob);
                if (tempJob == null)
                {
                    throw new JobExecutionException("Job not found: " + tempJob);
                }
                if (!(tempJob instanceof Job))
                {
                    throw new JobExecutionException(QuartzMessages.invalidJobObject().getMessage());
                }
            }
        }
        else if (!(tempJob instanceof Job))
        {
            throw new JobExecutionException(QuartzMessages.invalidJobObject().toString());
        }
        ((Job)tempJob).execute(jobExecutionContext);
    }
}