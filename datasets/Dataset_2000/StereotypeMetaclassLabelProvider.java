public class StereotypeMetaclassLabelProvider extends MetaclassLabelProvider {
	@Override
	public String getText(Object element) {
		if(element instanceof Stereotype){
			return ((Stereotype)element).getName();
		}
		return super.getText(element);
	}
}