public class RULE_MAX_SIZE extends RuleBase {
        private static RULE_MAX_SIZE sRULE_MAX_SIZE_INSTANCE = new RULE_MAX_SIZE();
    @Override
    public void onReceive(Context arg0, Intent arg1) {
    }
        public static RULE_MAX_SIZE getInstance() {
        return sRULE_MAX_SIZE_INSTANCE;
    }
                @Override
    public boolean evaluateRule(Rule rule, WorkOrder workOrder) {
        if (rule.getValue() != null) {            
            try {
                Long totalBytes = Long.parseLong(rule.getValue());
                Long specifiedBytes = Long.parseLong(workOrder.getPackages().get(0).properties
                        .get(QueueRequestProperties.RequiredProperties.REQPROP_TOTAL_LENGTH));
                return specifiedBytes <= totalBytes;
            } catch (NumberFormatException exec) {
                CmClientUtil.debugLog(getClass(), "evaluateRule", exec);
            }
        }
        return true;
    }
    @Override
    public void init(Context context) {
        super.init(context);
    }
    @Override
    public boolean isValid(String value) {
        if (value == null)
            return false;
        boolean parsed = false;
        try {
            Long.parseLong(value);
            parsed = true;
        } catch (NumberFormatException exec) {
            CmClientUtil.debugLog(getClass(), "RULE_MAX_SIZE", exec);
        } 
        return parsed;
    }
}