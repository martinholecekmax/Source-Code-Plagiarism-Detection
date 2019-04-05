public class CreateJobRequest extends AbstractRequest
{
    private User programmer;
    private String todo;
    private int priority;
    public CreateJobRequest(String userName, String password)
    {
        super(userName, password);
    }
    @Override
    protected AbstractResponse createResponse()
    {
        return new CreateJobResponse();
    }
    @Override
    protected void onProduceResponse() throws ModelException
    {
        User requestor = model.getUserByLogin(getUserName());
        model.createJobToBeDone(programmer, requestor, todo, priority);
    }
    public int getPriority()
    {
        return priority;
    }
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    public User getProgrammer()
    {
        return programmer;
    }
    public void setProgrammer(User programmer)
    {
        this.programmer = programmer;
    }
    public String getTodo()
    {
        return todo;
    }
    public void setTodo(String todo)
    {
        this.todo = todo;
    }
}