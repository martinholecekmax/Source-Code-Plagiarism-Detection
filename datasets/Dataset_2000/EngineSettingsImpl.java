public class EngineSettingsImpl extends EObjectImpl implements EngineSettings {
	
	protected EMap<String, String> settings;
	
	protected EngineSettingsImpl() {
		super();
	}
	
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.ENGINE_SETTINGS;
	}
	
	public EMap<String, String> getSettings() {
		if (settings == null) {
			settings = new EcoreEMap<String,String>(InstancePackage.Literals.STRING_TO_STRING_MAP, StringToStringMapImpl.class, this, InstancePackage.ENGINE_SETTINGS__SETTINGS);
		}
		return settings;
	}
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InstancePackage.ENGINE_SETTINGS__SETTINGS:
				return ((InternalEList<?>)getSettings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InstancePackage.ENGINE_SETTINGS__SETTINGS:
				if (coreType) return getSettings();
				else return getSettings().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InstancePackage.ENGINE_SETTINGS__SETTINGS:
				((EStructuralFeature.Setting)getSettings()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InstancePackage.ENGINE_SETTINGS__SETTINGS:
				getSettings().clear();
				return;
		}
		super.eUnset(featureID);
	}
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InstancePackage.ENGINE_SETTINGS__SETTINGS:
				return settings != null && !settings.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}