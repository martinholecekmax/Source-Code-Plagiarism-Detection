@AliasName(name = "TabSheet")
@AperteDoc(humanNameKey="widget.tab_sheet.name", descriptionKey="widget.tab_sheet.description")
@ChildrenAllowed(true)
@WidgetGroup("base-widgets")
public class TabSheetWidget extends BaseProcessToolVaadinWidget {
	private static final Logger logger = Logger.getLogger(TabSheetWidget.class.getName());
	private TabSheet ts = new TabSheet();
	@Override
	public Component render() {
		ts.setWidth("100%");
		return ts;
	}
	@Override
	public void addChild(ProcessToolWidget child) {
		if (!(child instanceof ProcessToolVaadinWidget)) {
			throw new IllegalArgumentException("child is not instance of " + ProcessToolVaadinWidget.class.getName());
		}
		Component component;
		ProcessToolVaadinWidget vChild = (ProcessToolVaadinWidget) child;
		try {
			component = vChild.render();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
            Panel p = new Panel();
            VerticalLayout vl = new VerticalLayout();
            vl.addComponent(new Label(getMessage("process.data.widget.exception-occurred")));
            vl.addComponent(new Label(e.getMessage()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            e.printStackTrace(new PrintWriter(baos));
            vl.addComponent(new Label("<pre>" + baos.toString() + "</pre>", CONTENT_XHTML));
            vl.addStyleName("error");
            p.addComponent(vl);
            p.setHeight("150px");
            component = p;
		}
		ts.addTab(component, getMessage(child.getAttributeValue("caption")), null);
		if (ts.getSelectedTab() == null)
			ts.setSelectedTab(component);
	}
}