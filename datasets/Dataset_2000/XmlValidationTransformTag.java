public class XmlValidationTransformTag extends TransformTag
{
   public XmlValidationTransformTag()
   {
   }
   private boolean isValid() throws Exception
   {
      try
      {
         Class helperClass = this.getHelper().getClass();
         Method method = helperClass.getMethod("isValid",null);
         Boolean result = (Boolean) method.invoke(this.getHelper(),null);
         return result.booleanValue();
      }
      catch(Exception e)
      {
         String error = "Failed to validate Address";
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGSERROR))
         {
            LogUtil.put(LogFactory.getInstance(error,this,"isValid()",e));
         }
         throw e;
      }
   }
   public int doStartTag() throws JspTagException
   {
      try
      {
         this.setHelper();
         if(this.isValid())
         {
            super.doStartTag();
            return this.EVAL_BODY_INCLUDE;
         }
         else
         {
            super.doStartTag();
            return this.SKIP_BODY;
         }
      }
      catch(LicensingException e)
      {
         AbResponseHandler.sendJspTagLicensingRedirect(this.pageContext, e);
         return SKIP_BODY;
      }
      catch(Exception e)
      {
         AbResponseHandler.sendJspTagRedirect(this.pageContext, e);
         return SKIP_BODY;
      }
   }
}