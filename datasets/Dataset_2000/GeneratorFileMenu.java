public class GeneratorFileMenu extends FileMenu {
	static final Logger logger = Logger.getLogger(GeneratorFileMenu.class.getPackage().getName());
	public GenerateFilesItem generateFilesItem;
	public RefreshItem refreshItem;
	protected GeneratorController _controller;
					public GeneratorFileMenu(GeneratorController controller) {
		super(controller);
		_controller = controller;
	}
	public GeneratorController getGeneratorController() {
		return _controller;
	}
	@Override
	public void addSpecificItems() {
		add(generateFilesItem = new GenerateFilesItem());
		add(refreshItem = new RefreshItem());
		addSeparator();
	}
	public class GenerateFilesItem extends FlexoMenuItem {
		public GenerateFilesItem() {
			super(new GenerateFilesAction(), "generate_files", null, getGeneratorController(), true);
		}
	}
	public class GenerateFilesAction extends AbstractAction {
		public GenerateFilesAction() {
			super();
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			logger.warning("Not implemented yet");
					}
	}
	public class RefreshItem extends FlexoMenuItem {
		public RefreshItem() {
			super(new RefreshAction(), "refresh", null, getGeneratorController(), true);
		}
	}
	public class RefreshAction extends AbstractAction {
		public RefreshAction() {
			super();
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (logger.isLoggable(Level.WARNING)) {
				logger.warning("Refresh not implemented");
							}
		}
	}
}