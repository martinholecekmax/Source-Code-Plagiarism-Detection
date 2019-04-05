class ChainedManagedUpdate implements UpdateCallback {
	private final UpdateCallback[] callbacks;
	ChainedManagedUpdate(UpdateCallback[] callbacks) {
		this.callbacks = (ObjectUtils.isEmpty(callbacks) ? new UpdateCallback[0] : callbacks);
	}
	public void update(Object instance, Map properties) {
		for (UpdateCallback callback : callbacks) {
			callback.update(instance, properties);
		}
	}
}