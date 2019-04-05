public interface RoolieConst
{
  public static class CLASS
  {
    public static final String DEFAULT_RULE_FACTORY = 
      DefaultRuleFactory.class.getName();
    public static final String DEFAULT_RULE_EVALUATOR =
      DefaultRuleEvaluator.class.getName();
  }
  public static class XML
  {
    public static class NODE
    {
      
      public static final String ROOLIE_RULES_CONFIG =
              "roolie-rules-config";
      
      public static final String RULE_DEFINITIONS = "rule-definitions";
      
      public static final String RULE_IMPLEMENTATIONS =
              "rule-implementations";
      
      public static final String ROOLIE_CONFIG = "roolie-config";
      
      public static final String RULE_DEF = "rule-def";
      
      public static final String RULE = "rule";
      
      public static final String RULE_IMPL = "rule-impl";
      
      public static final String PROPERTY = "property";
      
      public static final String LIST = "list";
      
      public static final String LIST_ITEM = "list-item";
      
      public static final String RULE_FACTORY_CLASS = "rule-factory-class";
      
      public static final String RULE_EVALUATOR_CLASS = "rule-evaluator-class";
    }
    public static class ATTRIB
    {
      
      public static final String NAME = "name";
      
      public static final String OR_NEXT_RULE = "or-next-rule";
      
      public static final String INVERSE = "inverse";
      
      public static final String CLASS = "class";
      
      public static final String VALUE = "value";
    }
  }
}