public class OAuthServiceFactoryTransformer extends JavassistTransformer {
    protected void transform(CtClass clazz) throws Exception {
        CtMethod method = clazz.getDeclaredMethod("getOAuthService");
        method.setBody("return new org.jboss.capedwarf.oauth.JBossOAuthService();");
    }
}