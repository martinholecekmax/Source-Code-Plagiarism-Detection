@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tab-folder-type", propOrder = {
    "layout",
    "layoutData",
    "item",
    "tooltip",
    "font",
    "controlState"
})
public class TabFolderType {
    protected LayoutType layout;
    @XmlElement(name = "layout-data")
    protected LayoutDataType layoutData;
    @XmlElement(required = true)
    protected List<TabItemType> item;
    protected String tooltip;
    protected FontType font;
    @XmlElement(name = "control-state")
    protected ControlStateType controlState;
    @XmlAttribute
    protected String style;
    @XmlAttribute
    protected String background;
    
    public LayoutType getLayout() {
        return layout;
    }
    
    public void setLayout(LayoutType value) {
        this.layout = value;
    }
    
    public LayoutDataType getLayoutData() {
        return layoutData;
    }
    
    public void setLayoutData(LayoutDataType value) {
        this.layoutData = value;
    }
    
    public List<TabItemType> getItem() {
        if (item == null) {
            item = new ArrayList<TabItemType>();
        }
        return this.item;
    }
    
    public String getTooltip() {
        return tooltip;
    }
    
    public void setTooltip(String value) {
        this.tooltip = value;
    }
    
    public FontType getFont() {
        return font;
    }
    
    public void setFont(FontType value) {
        this.font = value;
    }
    
    public ControlStateType getControlState() {
        return controlState;
    }
    
    public void setControlState(ControlStateType value) {
        this.controlState = value;
    }
    
    public String getStyle() {
        return style;
    }
    
    public void setStyle(String value) {
        this.style = value;
    }
    
    public String getBackground() {
        return background;
    }
    
    public void setBackground(String value) {
        this.background = value;
    }
}