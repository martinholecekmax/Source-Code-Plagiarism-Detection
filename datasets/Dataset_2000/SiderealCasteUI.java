public class SiderealCasteUI extends AbstractUI {
  public SiderealCasteUI(IResources resources) {
    super(resources);
  }
  public Icon getCasteIcon(IAstrologicalHouse house) {
    SiderealCaste caste = SiderealCaste.valueOf(house.getId());
    String iconName = "SiderealButton" + caste.name() + "16.png";     return getIcon(iconName);
  }
}