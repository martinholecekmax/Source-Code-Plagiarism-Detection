public class DeadProductionEliminator extends GrammarVisitor {
  
  public DeadProductionEliminator(Runtime runtime, Analyzer analyzer) {
    super(runtime, analyzer);
  }
  
  public Object visit(Module m) {
        analyzer.register(this);
    analyzer.init(m);
        if (m.hasProperty(Properties.ROOT)) {
      dispatch((NonTerminal)m.getProperty(Properties.ROOT));
    } else {
      for (Production p : m.productions) {
        if (p.hasAttribute(Constants.ATT_PUBLIC)) {
          dispatch(p.name);
        }
      }
    }
        for(Iterator<Production> iter = m.productions.iterator(); iter.hasNext();) {
      Production p = iter.next();
      if (! analyzer.isMarked(p.qName)) {
        if (runtime.test("optionVerbose")) {
          System.err.println("[Removing dead production " + p.qName + "]");
        }
        analyzer.remove((FullProduction)p);
        iter.remove();
      }
    }
        return null;
  }
  
  public Element visit(NonTerminal nt) {
    FullProduction p = analyzer.lookup(nt);
    if (! analyzer.isMarked(p.qName)) {
      analyzer.mark(p.qName);
      dispatch(p);
    }
    return nt;
  }
}