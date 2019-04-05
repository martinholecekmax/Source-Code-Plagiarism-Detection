public class GoBackAction extends AbstractGraphAction
{
    
    public GoBackAction( final NeoGraphViewPart view )
    {
        super( Actions.GO_BACK, Action.AS_PUSH_BUTTON, view );
        setEnabled( false );
    }
    
    @Override
    public void run()
    {
        graphView.goBack();
    }
}