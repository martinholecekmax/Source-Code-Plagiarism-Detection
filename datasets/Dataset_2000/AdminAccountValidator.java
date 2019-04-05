@Service
public class AdminAccountValidator {
    private static final Logger LOGGER = Logger.getLogger(AdminAccountValidator.class);
    @Autowired
    private EhourConfig ehourConfig;
    @Autowired
    private UserService userService;
    @Autowired
    private ConfigurationService configService;
    
    @PostConstruct
    public void checkAdminAccount() {
        if (!ehourConfig.isInitialized()) {
            LOGGER.info("eHour not initialized, initializing...");
            updateAdminPassword();
        } else {
            LOGGER.info("eHour already initialized");
        }
    }
    
    private void updateAdminPassword() {
        LOGGER.info("Setting password of admin account to default value");
        userService.changePassword("admin", "admin");
        LOGGER.info("Admin password set to default value");
        setEhourInitialized();
    }
    
    private void setEhourInitialized() {
        EhourConfigStub config = configService.getConfiguration();
        config.setInitialized(true);
        configService.persistConfiguration(config);
        LOGGER.info("eHour's state to initialized");
    }
}