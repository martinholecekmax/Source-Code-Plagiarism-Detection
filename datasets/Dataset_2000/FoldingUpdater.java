public class FoldingUpdater extends FolderBase {
	@Override
	protected void sendVisitorToAST(
			HashMap<Annotation, Position> newAnnotations,
			List<Annotation> annotations, Object ast) {
		if (ast instanceof IConstructor) {
			try {
				((IConstructor) ast).accept(new TreeVisitor() {
					public IConstructor visitTreeCycle(IConstructor arg)
							throws VisitorException {
						return null;
					}
					@Override
					public IConstructor visitTreeChar(IConstructor arg) throws VisitorException {
						return null;
					}
					@Override
					public IConstructor visitTreeAppl(IConstructor arg) throws VisitorException {
						IConstructor prod = TreeAdapter.getProduction(arg);
						IValueFactory VF = ValueFactoryFactory.getValueFactory();
						if (ProductionAdapter.hasAttribute(prod, Factory.Attr_Tag.make(VF, VF.node("Foldable")))) {
							makeAnnotation(arg, false);	
						}
						else if (ProductionAdapter.hasAttribute(prod, Factory.Attr_Tag.make(VF, VF.node("Folded")))) {
							makeAnnotation(arg, true);	
						}
						else if (arg.getAnnotation("foldable") != null) {
							makeAnnotation(arg, false);
						}
						else if (arg.getAnnotation("folded") != null) {
							makeAnnotation(arg, true);
						}
						if (!TreeAdapter.isLexical(arg)) {
							for (IValue kid :  TreeAdapter.getASTArgs(arg)) {
								kid.accept(this);
							}
						}
						return null;
					}
					public IConstructor visitTreeAmb(IConstructor arg) throws VisitorException {
						return null;
					}
				});
			} catch (VisitorException e) {
				Activator.getInstance().logException(e.getMessage(), e);
			}
		}
	}
	@Override
	public void makeAnnotation(Object arg, boolean folded) {
		IConstructor c = (IConstructor) arg;
		ISourceLocation l = TreeAdapter.getLocation(c);
		if (l != null && l.getBeginLine() != l.getEndLine()) {
			super.makeAnnotation(arg, folded);
		}
	}
}