public class ManagedServiceInstanceTrackerPostProcessor implements BeanFactoryAware, BundleContextAware,
		InitializingBean, BeanPostProcessor, DestructionAwareBeanPostProcessor, DisposableBean {
	private final String trackedBean;
	private DefaultManagedServiceBeanManager managedServiceManager;
	private String pid;
	private String updateMethod;
	private boolean autowireOnUpdate = false;
	private BundleContext bundleContext;
	private BeanFactory beanFactory;
	public ManagedServiceInstanceTrackerPostProcessor(String beanNameToTrack) {
		this.trackedBean = beanNameToTrack;
	}
	public void afterPropertiesSet() throws Exception {
		ConfigurationAdminManager cam = new ConfigurationAdminManager(pid, bundleContext);
		managedServiceManager = new DefaultManagedServiceBeanManager(autowireOnUpdate, updateMethod, cam, beanFactory);
	}
	public void destroy() throws Exception {
		managedServiceManager.destroy();
	}
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
				if (trackedBean.equals(beanName)) {
			return managedServiceManager.register(bean);
		}
		return bean;
	}
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		if (trackedBean.equals(beanName)) {
			managedServiceManager.unregister(bean);
		}
	}
	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
	public void setPersistentId(String pid) {
		this.pid = pid;
	}
	
	public void setAutowireOnUpdate(boolean autowireOnUpdate) {
		this.autowireOnUpdate = autowireOnUpdate;
	}
	
	public void setUpdateMethod(String methodName) {
		this.updateMethod = methodName;
	}
}