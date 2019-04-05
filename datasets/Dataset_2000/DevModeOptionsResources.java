public interface DevModeOptionsResources extends ClientBundle {
  public interface Css extends CssResource {  
    String errorMessage();
    String exclude();
    String explanation();
    String header();
    String important();
    String include();
    String logo();
    String mainPanel();
    String savedHosts();
    String savedHostsHeading();
    String textBox();
    String textCol();
  }
  @Source("com/google/gwt/devmodeoptions/client/resources/DevModeOptions.css")
  Css css();
  @Source("com/google/gwt/devmodeoptions/client/resources/gwt128.png")
  ImageResource gwt128();
  @Source("com/google/gwt/devmodeoptions/client/resources/gwt16.png")
  ImageResource gwt16();
  @Source("com/google/gwt/devmodeoptions/client/resources/gwt32.png")
  ImageResource gwt32();
  @Source("com/google/gwt/devmodeoptions/client/resources/gwt48.png")
  ImageResource gwt48();
  @Source("com/google/gwt/devmodeoptions/client/resources/gwt64.png")
  ImageResource gwt64();
  @Source("com/google/gwt/devmodeoptions/client/resources/warning.png")
  ImageResource warning();
}