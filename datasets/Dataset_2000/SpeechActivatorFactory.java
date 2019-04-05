public class SpeechActivatorFactory
{
    public static SpeechActivator createSpeechActivator(Context context, 
            SpeechActivationListener callback, String type)
    {
        SpeechActivator speechActivator = null;
        if (type.equals(context.getResources().getString(R.string.speech_activation_button)))
        {
            speechActivator = null;
        }
        else if (type.equals(context.getResources().getString(R.string.speech_activation_movement)))
        {
            speechActivator = new MovementActivator(context, callback);
        }
        else if (type.equals(context.getResources().getString(R.string.speech_activation_clap)))
        {
            speechActivator = new ClapperActivator(context, callback);
        }
        else if (type.equals(context.getResources().getString(R.string.speech_activation_speak)))
        {
            speechActivator = new WordActivator(context, callback, "hello");
        }
        return speechActivator;
    }
    public static String getLabel(Context context, SpeechActivator speechActivator)
    {
        String label = "";
        if (speechActivator == null)
        {
            label = context.getString(R.string.speech_activation_button);
        }
        else if (speechActivator instanceof WordActivator)
        {
            label = context.getString(R.string.speech_activation_speak);
        }
        else if ((speechActivator instanceof MovementActivator))
        {
            label = context.getString(R.string.speech_activation_movement);
        }
        else if ((speechActivator instanceof ClapperActivator))
        {
            label = context.getString(R.string.speech_activation_clap);
        }
        else
        {
            label = context.getString(R.string.speech_activation_button);
        }
        return label;
    }
}