public class ApplicationSerializationProgressLabel extends Composite
{
   interface MyBinder
         extends UiBinder<Widget, ApplicationSerializationProgressLabel>
   {}
   private static MyBinder binder = GWT.create(MyBinder.class);
   public ApplicationSerializationProgressLabel()
   {
      initWidget(binder.createAndBindUi(this));
   }
   public void setText(String text)
   {
      label_.setText(text);
   }
   @UiField
   Label label_;
}