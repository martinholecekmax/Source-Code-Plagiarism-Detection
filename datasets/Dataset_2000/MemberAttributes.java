public class MemberAttributes {
  String              name             = "";
  String              type             = "";
  String              interfaceName    = null;
  PsiField            field            = null;
  PsiMethod           method           = null;
  PsiClass            childClass       = null;
  PsiClassInitializer classInitializer = null;
  int                 modifiers        = 0;
  String              modifierString   = "";
  int                 nParameters      = 0;
}