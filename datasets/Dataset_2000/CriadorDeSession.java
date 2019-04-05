@Component
public class CriadorDeSession implements ComponentFactory<Session> {
	private final SessionFactory factory;
	private Session session;
	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}
	@PostConstruct
	public void abre() {
		this.session = factory.openSession();
	}
	public Session getInstance() {
		return this.session;
	}
	@PreDestroy
	public void fecha() {
		this.session.close();
	}
}