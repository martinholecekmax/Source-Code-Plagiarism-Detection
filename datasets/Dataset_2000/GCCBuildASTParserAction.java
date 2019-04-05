public class GCCBuildASTParserAction extends C99BuildASTParserAction {
	private final ICNodeFactory nodeFactory;
	public GCCBuildASTParserAction(ITokenStream parser, ScopedStack<Object> astStack, ICNodeFactory nodeFactory, ISecondaryParserFactory parserFactory) {
		super(parser, astStack, nodeFactory, parserFactory);
		this.nodeFactory = nodeFactory;
	}
	
	public void consumeDesignatorFieldGCC() {
		IASTName name = createName(stream.getLeftIToken());
		ICASTFieldDesignator designator = nodeFactory.newFieldDesignator(name);
		setOffsetAndLength(designator);
		astStack.push(designator);
	}
	
	public void consumeDesignatorArrayRange() {
		IASTExpression ceiling = (IASTExpression) astStack.pop();
		IASTExpression floor = (IASTExpression) astStack.pop();
		IGCCASTArrayRangeDesignator designator = nodeFactory.newArrayRangeDesignatorGCC(floor, ceiling);
		setOffsetAndLength(designator);
		astStack.push(designator);
	}
	
	public void consumeDeclarationSpecifiersTypeof() {
		List<Object> topScope = astStack.closeScope();
				IASTExpression expr = findFirstAndRemove(topScope, IASTExpression.class);
		ICASTSimpleDeclSpecifier declSpec = nodeFactory.newSimpleDeclSpecifierGCC(expr);
				for(Object token : topScope) {
			setSpecifier(declSpec, token);
		}
		setOffsetAndLength(declSpec);
		astStack.push(declSpec);
	}
}