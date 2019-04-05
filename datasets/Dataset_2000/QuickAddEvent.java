@ComponentConfig(
                 events = {
                     @EventConfig(listeners = QuickAddEvent.AddActionListener.class)
                 }
)
public class QuickAddEvent extends UIComponent {
  static public class AddActionListener extends ActionListener<QuickAddEvent> {
    protected void processEvent(Event<QuickAddEvent> event) throws Exception {
    }
  }
}