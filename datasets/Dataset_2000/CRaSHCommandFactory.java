public class CRaSHCommandFactory implements Factory<Command> {
  
  final TermIOHandler handler;
  public CRaSHCommandFactory(TermIOHandler handler) {
    if (handler == null) {
      throw new NullPointerException("No null builder accepted");
    }
        this.handler = handler;
  }
  public Command create() {
    return new CRaSHCommand(this);
  }
}