@Deprecated
public class TipiEchoEmbedComponent extends TipiEmbedComponent {
	private static final long serialVersionUID = -588381253551933691L;
	private final static Logger logger = LoggerFactory
			.getLogger(TipiEchoEmbedComponent.class);
	private TipiEchoStandaloneToplevel tet;
	public TipiEchoEmbedComponent() {
	}
	public Object createContainer() {
		stc = new TipiEchoStandaloneContainer((TipiEchoInstance) ((EchoTipiContext) getContext()).getInstance(),
				(EchoTipiContext) getContext());
		tet = (TipiEchoStandaloneToplevel) stc.getContext().getDefaultTopLevel();
		Component c = (Component) tet.getContainer();
		c.setBackground(new Color(255, 0, 0));
		return c;
			}
	public void setComponentValue(String name, Object value) {
		if (name.equals("tipiCodeBase")) {
			stc.getContext().setTipiResourceLoader(getContext().getTipiResourceLoader());
			return;
		}
		if (name.equals("resourceCodeBase")) {
						stc.getContext().setGenericResourceLoader(getContext().getGenericResourceLoader());
			return;
											}
		super.setComponentValue(name, value);
	}
	protected void switchToDefinition(final String nameVal) {
		logger.info("Switching to def: " + nameVal);
		try {
			stc.getContext().switchToDefinition(nameVal);
		} catch (TipiException e) {
						logger.error("Error: ",e);
		}
	}
}