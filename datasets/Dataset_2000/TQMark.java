public final class TQMark extends Token
{
  public TQMark()
  {
    super.setText("?");
  }
  public TQMark(int line, int pos)
  {
    super.setText("?");
    setLine(line);
    setPos(pos);
  }
  public Object clone()
  {
    return new TQMark(getLine(), getPos());
  }
  public void apply(Switch sw)
  {
    ((Analysis) sw).caseTQMark(this);
  }
  public void setText(String text)
  {
    throw new RuntimeException("Cannot change TQMark text.");
  }
}