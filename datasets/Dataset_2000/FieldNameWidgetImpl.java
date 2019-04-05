public class FieldNameWidgetImpl implements IsWidget {
    private SmallLabel view = new SmallLabel();
    public FieldNameWidgetImpl(String fieldName) {
        view.setText(fieldName + ":");
        view.addClickHandler(createClickHandler());
    }
    private ClickHandler createClickHandler() {
        return new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                            }
        };
    }
    @Override
    public Widget asWidget() {
        return view;
    }
}