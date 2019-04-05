public abstract class GhcCompilerTab extends Tab {
  public GhcCompilerTab( final IPreferenceStore store ) {
    super( store );
  }
      DialogField createBooleanField( final Composite parent, final String name ) {
    String text = ParamsUITexts.getShortDescription( name );
    String tooltip = text + "\n" + name;     BooleanDialogField result = new BooleanDialogField( parent, text, tooltip );
    result.addDialogFieldListener( new IDialogFieldListener() {
      public void infoChanged( final Object newInfo ) {
        boolean selected = ( ( Boolean )newInfo ).booleanValue();
        getPreferenceStore().setValue( name, selected );
      }
    } );
    result.setInfo( getFromStore( name ) );
    return result;
  }
      private Boolean getFromStore( final String name ) {
    boolean value = getPreferenceStore().getBoolean( name );
    return ( value ) ? Boolean.TRUE : Boolean.FALSE;
  }
}