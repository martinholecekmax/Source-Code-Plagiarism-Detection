@Path("springautowiredsingleton")
@Component
@Scope( "singleton" )
public class AutowiredBySpringSingletonResource extends AutowiredSingletonResourceBase {
    @Autowired
    public AutowiredBySpringSingletonResource( Item item ) {
        super.setItem( item );
    }
}