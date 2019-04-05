@Implementation(responseObject = SuccessResponse.class, description = "Deletes a particular egress rule from this security group", since="3.0.0")
public class RevokeSecurityGroupEgressCmd extends BaseAsyncCmd {
    public static final Logger s_logger = Logger.getLogger(RevokeSecurityGroupEgressCmd.class.getName());
    private static final String s_name = "revokesecuritygroupegress";
                @IdentityMapper(entityTableName="security_group_rule")
    @Parameter(name = ApiConstants.ID, type = CommandType.LONG, required = true, description = "The ID of the egress rule")
    private Long id;
                public Long getId() {
        return id;
    }
                @Override
    public String getCommandName() {
        return s_name;
    }
    public static String getResultObjectName() {
        return "revokesecuritygroupegress";
    }
    @Override
    public long getEntityOwnerId() {
        SecurityGroup group = _entityMgr.findById(SecurityGroup.class, getId());
        if (group != null) {
            return group.getAccountId();
        }
        return Account.ACCOUNT_ID_SYSTEM;     }
    @Override
    public String getEventType() {
        return EventTypes.EVENT_SECURITY_GROUP_REVOKE_EGRESS;
    }
    @Override
    public String getEventDescription() {
        return "revoking egress rule id: " + getId();
    }
    @Override
    public void execute() {
        boolean result = _securityGroupService.revokeSecurityGroupEgress(this);
        if (result) {
            SuccessResponse response = new SuccessResponse(getCommandName());
            this.setResponseObject(response);
        } else {
            throw new ServerApiException(BaseCmd.INTERNAL_ERROR, "Failed to revoke security group egress rule");
        }
    }
    @Override
    public AsyncJob.Type getInstanceType() {
        return AsyncJob.Type.SecurityGroup;
    }
    @Override
    public Long getInstanceId() {
        return getId();
    }
}