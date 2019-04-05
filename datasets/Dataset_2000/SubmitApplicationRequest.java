@Public
@Stable
public interface SubmitApplicationRequest {
  
  @Public
  @Stable
  public abstract ApplicationSubmissionContext getApplicationSubmissionContext();
  
  @Public
  @Stable
  public abstract void setApplicationSubmissionContext(
      ApplicationSubmissionContext context);
}