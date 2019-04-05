public class UndoFactory implements CommandFactory {
    private Command command;
    public String begin () {
        setCommand(new UndoCommand());
        return Messages.UndoPerformed;
    }
    
    protected void setCommand (Command command) {
        this.command = command;
    }
    public String next (Object parameter) throws InvalidParameterException {
        return null;
    }
    public boolean isDone () {
        return true;
    }
    public String cancel () {
        return null;
    }
    public void drawVisualHelper () {
            }
    public String getName () {
        return "undo";     }
    
    public Parser getNextParser () {
        return null;
    }
    public List<Command> getCommands () {
        List<Command> cmds = null;
        if (command != null) {
            cmds = new ArrayList<Command>();
            cmds.add(command);
            setCommand(null);
        }
        return cmds;
    }
    
    public boolean isTransformFactory () {
        return false;
    }
}