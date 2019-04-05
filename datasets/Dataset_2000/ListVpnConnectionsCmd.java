@Implementation(description="Lists site to site vpn connection gateways", responseObject=Site2SiteVpnConnectionResponse.class)
public class ListVpnConnectionsCmd extends BaseListProjectAndAccountResourcesCmd {
    public static final Logger s_logger = Logger.getLogger (ListVpnConnectionsCmd.class.getName());
    private static final String s_name = "listvpnconnectionsresponse";
                @IdentityMapper(entityTableName="s2s_vpn_connection")
    @Parameter(name=ApiConstants.ID, type=CommandType.LONG, description="id of the vpn connection")
    private Long id;
    @IdentityMapper(entityTableName="vpc")
    @Parameter(name=ApiConstants.VPC_ID, type=CommandType.LONG, description="id of vpc")
    private Long vpcId;
                public Long getId() {
        return id;
    }
    public Long getVpcId() {
        return vpcId;
    }
                @Override
    public String getCommandName() {
        return s_name;
    }
    @Override
    public void execute(){
        List<Site2SiteVpnConnection> conns = _s2sVpnService.searchForVpnConnections(this);
        ListResponse<Site2SiteVpnConnectionResponse> response = new ListResponse<Site2SiteVpnConnectionResponse>();
        List<Site2SiteVpnConnectionResponse> connResponses = new ArrayList<Site2SiteVpnConnectionResponse>();
        if (conns != null && !conns.isEmpty()) {
        	for (Site2SiteVpnConnection conn : conns) {
                if (conn == null) {
                    continue;
                }
            	Site2SiteVpnConnectionResponse site2SiteVpnConnectonRes = _responseGenerator.createSite2SiteVpnConnectionResponse(conn);
            	site2SiteVpnConnectonRes.setObjectName("vpnconnection");
                connResponses.add(site2SiteVpnConnectonRes);
            }
        }
        response.setResponses(connResponses);
        response.setResponseName(getCommandName());
        this.setResponseObject(response);
    }
}