public final class Accessibility {
  public static final String ROLE_TREE = "tree";
  public static final String ROLE_TREEITEM = "treeitem";
  public static final String ROLE_BUTTON = "button";
  public static final String ROLE_TABLIST = "tablist";
  public static final String ROLE_TAB = "tab";
  public static final String ROLE_TABPANEL = "tabpanel";
  public static final String ROLE_MENUBAR = "menubar";
  public static final String ROLE_MENUITEM = "menuitem";
  public static final String STATE_ACTIVEDESCENDANT = "aria-activedescendant";
  public static final String STATE_POSINSET = "aria-posinset";
  public static final String STATE_SETSIZE = "aria-setsize";
  public static final String STATE_SELECTED = "aria-selected";
  public static final String STATE_EXPANDED = "aria-expanded";
  public static final String STATE_LEVEL = "aria-level";
  public static final String STATE_HASPOPUP = "aria-haspopup";
  public static final String STATE_PRESSED = "aria-pressed";
  private static final String ATTR_NAME_ROLE = "role";
  
  public static String getRole(Element elem) {
    return elem.getAttribute(ATTR_NAME_ROLE);
  }
  
  public static String getState(Element elem, String stateName) {
    return elem.getAttribute(stateName);
  }
  
  public static void removeState(Element elem, String stateName)  {
    elem.removeAttribute(stateName);
  }
  
  public static void setRole(Element elem, String roleName) {
    elem.setAttribute(ATTR_NAME_ROLE, roleName);
  }
  
  public static void setState(Element elem, String stateName, String stateValue) {
    elem.setAttribute(stateName, stateValue);
  }
  private Accessibility() {
  }
}