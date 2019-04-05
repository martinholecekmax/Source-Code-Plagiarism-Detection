public class DomainInspectorWidget extends CustomInspectorWidget<Domain> {
	protected static final Logger logger = Logger.getLogger(DomainInspectorWidget.class.getPackage().getName());
	protected DomainSelector _selector;
	public DomainInspectorWidget(PropertyModel model, AbstractController controller) {
		super(model, controller);
		_selector = new DomainSelector(null, null) {
			@Override
			public void apply() {
				super.apply();
				updateModelFromWidget();
			}
			@Override
			public void cancel() {
				super.cancel();
				updateModelFromWidget();
			}
		};
		getDynamicComponent().addFocusListener(new WidgetFocusListener(this) {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (logger.isLoggable(Level.FINE)) {
					logger.fine("Focus gained in " + getClass().getName());
				}
				super.focusGained(arg0);
				_selector.getTextField().requestFocus();
				_selector.getTextField().selectAll();
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if (logger.isLoggable(Level.FINE)) {
					logger.fine("Focus lost in " + getClass().getName());
				}
				super.focusLost(arg0);
			}
		});
	}
	@Override
	public Class getDefaultType() {
		return Domain.class;
	}
	@Override
	public synchronized void updateWidgetFromModel() {
		_selector.setEditedObject(getObjectValue());
		_selector.setRevertValue(getObjectValue());
	}
	
	@Override
	public synchronized void updateModelFromWidget() {
		setObjectValue(_selector.getEditedObject());
		super.updateModelFromWidget();
	}
	@Override
	public JComponent getDynamicComponent() {
		return _selector;
	}
	@Override
	public void setProject(FlexoProject aProject) {
		super.setProject(aProject);
		_selector.setProject(aProject);
	}
	public DomainSelector getSelector() {
		return _selector;
	}
	@Override
	public void fireEditingCanceled() {
		if (_selector != null) {
			_selector.closePopup();
		}
	}
	@Override
	public void fireEditingStopped() {
		if (_selector != null) {
			_selector.closePopup();
		}
	}
}