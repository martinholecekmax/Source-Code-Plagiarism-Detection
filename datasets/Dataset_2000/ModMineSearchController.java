public class ModMineSearchController extends TilesAction
{
    
    @Override
    public ActionForward execute(ComponentContext context,
            ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        final InterMineAPI im = SessionMethods.getInterMineAPI(request.getSession());
        ModMineSearch.initModMineSearch(im);
        return null;
    }
}