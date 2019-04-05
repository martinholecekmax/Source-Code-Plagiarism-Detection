public class ResourcesTypeImpl extends EObjectImpl implements ResourcesType {
	
	protected EList<Resource> resource;
	
	protected ResourcesTypeImpl() {
		super();
	}
	
	@Override
	protected EClass eStaticClass() {
		return POMPackage.Literals.RESOURCES_TYPE;
	}
	
	public EList<Resource> getResource() {
		if (resource == null) {
			resource = new EObjectContainmentEList<Resource>(Resource.class, this, POMPackage.RESOURCES_TYPE__RESOURCE);
		}
		return resource;
	}
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case POMPackage.RESOURCES_TYPE__RESOURCE:
				return ((InternalEList<?>)getResource()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case POMPackage.RESOURCES_TYPE__RESOURCE:
				return getResource();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case POMPackage.RESOURCES_TYPE__RESOURCE:
				getResource().clear();
				getResource().addAll((Collection<? extends Resource>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case POMPackage.RESOURCES_TYPE__RESOURCE:
				getResource().clear();
				return;
		}
		super.eUnset(featureID);
	}
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case POMPackage.RESOURCES_TYPE__RESOURCE:
				return resource != null && !resource.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}