public class AbstractGeneDBFormController {
    private Logger logger = Logger.getLogger(AbstractGeneDBFormController.class);
            private ConversionService conversionService;
        @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setConversionService(conversionService);
            }
    public static List<GeneSummary> fromIDs(List<String> results) {
        List<GeneSummary> gs = Lists.newArrayListWithExpectedSize(results.size());
        for (Object o  : results) {
            gs.add(new GeneSummary((String) o));
        }
        return gs;
    }
    protected static GeneSummary fromID(String result) {
		return new GeneSummary(result);
    }
    protected String findTaxonName(Query query) {
        String taxonName = null;
        if (query instanceof TaxonQuery) {
            System.err.println("query is a TaxonQuery");
            TaxonNodeList nodes = ((TaxonQuery) query).getTaxons();
            if (nodes != null && nodes.getNodeCount() > 0) {
                TaxonNode tn = nodes.getNodes().get(0);
                System.err.println("Got a TaxonNodeList out tn="+tn);
                taxonName = tn.getLabel();
            }         }
        System.err.println("Returning a name of '"+taxonName+"'");
        return taxonName;
    }
    protected Errors initialiseQueryForm(Query query, ServletRequest request){
                ServletRequestDataBinder binder = new ServletRequestDataBinder(query);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), false, 10));
                        binder.setConversionService(conversionService);
                binder.bind(request);
                BindingResult br = binder.getBindingResult();
        return br;
    }
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
}