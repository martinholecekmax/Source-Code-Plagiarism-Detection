public class UimSheetLabelProvider extends BaseLabelProvider implements ILabelProvider{
	
	public String getText(Object element){
		element = unwrap(element);
		if(element instanceof UimNavigatorGroup){
			return ((UimNavigatorGroup) element).getGroupName();
		}
		IElementType etype = getElementType(getView(element));
		return etype == null ? "" : etype.getDisplayName();
	}
	
	public Image getImage(Object element){
		IElementType etype = getElementType(getView(unwrap(element)));
		return etype == null ? null : UimElementTypes.getImage(etype);
	}
	
	private Object unwrap(Object element){
		if(element instanceof IStructuredSelection){
			return ((IStructuredSelection) element).getFirstElement();
		}
		return element;
	}
	
	private View getView(Object element){
		if(element instanceof View){
			return (View) element;
		}
		if(element instanceof IAdaptable){
			return (View) ((IAdaptable) element).getAdapter(View.class);
		}
		return null;
	}
	
	private IElementType getElementType(View view){
				while(view != null){
			int vid = UimVisualIDRegistry.getVisualID(view);
			IElementType etype = UimElementTypes.getElementType(vid);
			if(etype != null){
				return etype;
			}
			view = view.eContainer() instanceof View ? (View) view.eContainer() : null;
		}
		return null;
	}
}