public class CorrespondingMemberRequest
{
    public static Builder newCorrespondingMemberRequest()
    {
        return new Builder();
    }
    private Builder builder;
    private CorrespondingMemberRequest(Builder builder)
    {
        this.builder = builder;
    }
    public IMethod getCurrentMethod()
    {
        return builder.currentMethod;
    }
    public String getPromptText()
    {
        return builder.promptText;
    }
    public boolean shouldCreateClassIfNoResult()
    {
        return builder.createClassIfNoResult;
    }
    public boolean shouldReturn(MemberType memberType)
    {
        return builder.expectedMemberType == memberType;
    }
    public boolean shouldUseExtendedSearch()
    {
        return builder.extendedSearch;
    }
    public static enum MemberType
    {
        TYPE, TYPE_OR_METHOD
    }
    public static final class Builder
    {
        private boolean createClassIfNoResult;
        private IMethod currentMethod;
        private boolean extendedSearch;
        private String promptText;
        private MemberType expectedMemberType = MemberType.TYPE_OR_METHOD;
        private Builder()
        {
        }
        
        public Builder createClassIfNoResult(String promptText)
        {
            this.createClassIfNoResult = true;
            this.promptText = promptText;
            return this;
        }
        
        public Builder extendedSearch(boolean extendedSearch)
        {
            this.extendedSearch = extendedSearch;
            return this;
        }
        
        public Builder withCurrentMethod(IMethod method)
        {
            currentMethod = method;
            return this;
        }
        public Builder withExpectedResultType(MemberType memberType)
        {
            this.expectedMemberType = memberType;
            return this;
        }
        public CorrespondingMemberRequest build()
        {
            return new CorrespondingMemberRequest(this);
        }
    }
}