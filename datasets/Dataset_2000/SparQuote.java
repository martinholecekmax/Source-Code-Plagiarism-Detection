public class SparQuote extends AbstractView
{
  
  public void bind() throws Exception
  {
    I18N i18n = Application.getPluginLoader().getPlugin(HBCI.class).getResources().getI18N();
    GUI.getView().setTitle(i18n.tr("Sparquote eines Kontos"));
    de.willuhn.jameica.hbci.gui.parts.SparQuote q = new de.willuhn.jameica.hbci.gui.parts.SparQuote();
    q.paint(getParent());
  }
}