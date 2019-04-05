public abstract class WatchFileEventHandler extends JavaScriptFunctionWrapper {
    @Override
    public void call(JavaScriptFunctionArguments args) {
        onEvent(args.length() > 0 ? (Stat) args.get(0) : null, 
                args.length() > 1 ? (Stat) args.get(1) : null);
    }
    public abstract void onEvent(Stat curr, Stat prev);
}