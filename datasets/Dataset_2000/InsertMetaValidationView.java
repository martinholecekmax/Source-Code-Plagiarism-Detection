public class InsertMetaValidationView extends MetaView implements ValidationComponentInterface
{
   public InsertMetaValidationView(TransformInfoInterface transformInfoInterface) throws Exception
   {
      super(transformInfoInterface);
   }
    public Document toXmlDoc() throws Exception
    {
        return null;
    }
   public Boolean isValid()
   {
      try
      {
         Boolean isValid = Boolean.TRUE;
                  CustomizerUtil.insert(this.getTransformInfoInterface(),(DomNodeInterface) this);
         return isValid;
      }
      catch(Exception e)
      {
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.VIEWERROR))
         {
            LogUtil.put(LogFactory.getInstance("Failed to validate",this,"isValid()",e));
         }
         return Boolean.FALSE;
      }
   }
   public String validationInfo()
   {
      try
      {
         StringBuffer stringBuffer = new StringBuffer();
         return stringBuffer.toString();
      }
      catch(Exception e)
      {
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.VIEWERROR))
         {
            LogUtil.put(LogFactory.getInstance("Failed to generate validation error info",this,"validationInfo()",e));
         }
         return "Error Getting Validation Info";
      }
   }
   public Document toValidationInfoDoc()
   {
      return null;
   }
   public Node toValidationInfoNode(Document document)
   {
      return null;
   }
}