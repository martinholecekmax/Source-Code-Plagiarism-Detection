public class CountShoppingItemProductsByUser  extends CommonGroupBuyService {
    private String appId;
    private String userId;
    private String itemIdArray;
    private boolean requireMatch = false;
    public boolean setDataFromRequest(HttpServletRequest request) {
        userId = request.getParameter(ServiceConstant.PARA_USERID);
        appId = request.getParameter(ServiceConstant.PARA_APPID);
        itemIdArray = request.getParameter(ServiceConstant.PARA_ITEMID_ARRAY);
        String str_requireMatch = request.getParameter(ServiceConstant.PARA_REQUIRE_MATCH);
        if(str_requireMatch != null && str_requireMatch.equals(ServiceConstant.NEED_REQURIE_MATCH)) {
            requireMatch = true;
        }
        if (!check(userId, ErrorCode.ERROR_PARAMETER_USERID_EMPTY, ErrorCode.ERROR_PARAMETER_USERID_NULL)) {
            return false;
        }
        if (!check(appId, ErrorCode.ERROR_PARAMETER_APPID_EMPTY, ErrorCode.ERROR_PARAMETER_APPID_NULL)) {
            return false;
        }
        return true;
    }
    @Override
    public boolean needSecurityCheck() {
        return false;
    }
    @Override
    public void handleData() {
        String[] itemArray = null;
        if(!StringUtil.isEmpty(itemIdArray)) {
            itemArray = itemIdArray.split(" ");
        }
        if(requireMatch) {
            RecommendItemManager.matchShoppingItem(mongoClient, userId, itemArray);
        }
        Map<String, Integer> map = UserManager.getUserRecommendItemCountMap(mongoClient, userId, itemArray);
        if (map == null) {
            return;
        }
        resultData = CommonServiceUtils.userShoppingItemProductCountToJSONArray(map);
    }
}