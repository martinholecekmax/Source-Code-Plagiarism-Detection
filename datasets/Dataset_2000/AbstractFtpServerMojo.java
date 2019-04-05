public abstract class AbstractFtpServerMojo extends AbstractMojo {

protected MavenProject mavenProject;

protected User	adminUser;

protected List<User> users;

protected File serverRoot;

protected int port;

protected Map<String,String> systemPropertyVariables;

protected boolean allowAnonymousLogin = false;
}