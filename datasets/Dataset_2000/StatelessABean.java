@Stateless
@Local(WhoAmI.class)
@RolesAllowed("Admin")
@SecurityDomain("other")
public class StatelessABean implements WhoAmI {
    @EJB(beanName = "StatelessBBean")
    private WhoAmI beanB;
    public String getCallerPrincipal() {
        return beanB.getCallerPrincipal();
    }
}