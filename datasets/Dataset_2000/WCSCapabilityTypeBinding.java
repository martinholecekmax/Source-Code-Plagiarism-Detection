public class WCSCapabilityTypeBinding extends AbstractComplexBinding {
	
	public QName getTarget() {
		return WCS.WCSCapabilityType;
	}
		
	public Class getType() {
		return null;
	}
		
	public Object parse(ElementInstance instance, Node node, Object value) 
		throws Exception {
				return super.parse(instance,node,value);
	}
}