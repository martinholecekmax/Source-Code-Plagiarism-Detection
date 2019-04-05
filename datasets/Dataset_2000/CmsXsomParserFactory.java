public class CmsXsomParserFactory {
	@Autowired
	private AnnotationParserFactory annotationParserFactory;
	@Autowired
	private ErrorHandler errorHandler;
	@Autowired
	private EntityResolverForBuiltInSchemas entityResolver;
	public XSOMParser createXsomParser(){
		XSOMParser xsomParser = new XSOMParser();
		xsomParser.setAnnotationParser(annotationParserFactory);
		xsomParser.setErrorHandler(errorHandler);
		xsomParser.setEntityResolver(entityResolver);
		return xsomParser;
	}
	public XSOMParser createXsomParserForValidation(CmsEntityResolverForValidation entityResolverForValidation){
		XSOMParser xsomParser = new XSOMParser();
		xsomParser.setAnnotationParser(annotationParserFactory);
		xsomParser.setErrorHandler(errorHandler);
		if (entityResolverForValidation!=null){
			entityResolverForValidation.setBuiltInEntityResolver(entityResolver);
		}
		xsomParser.setEntityResolver(entityResolverForValidation);
		return xsomParser;
	}
}