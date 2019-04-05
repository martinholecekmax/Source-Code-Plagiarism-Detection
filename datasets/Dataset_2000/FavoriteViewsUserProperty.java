public class FavoriteViewsUserProperty extends UserProperty {
	private Set<String> favoriteViews = Collections
			.synchronizedSet(new HashSet<String>());
	public boolean isFavorite(String viewId) {
		return favoriteViews.contains(viewId);
	}
	public void setFavorite(String viewId, boolean favorite) {
		if (favorite) {
			favoriteViews.add(viewId);
		} else {
			favoriteViews.remove(viewId);
		}
	}
	@Override
	public UserProperty reconfigure(StaplerRequest req, JSONObject form)
			throws FormException {
		return this;
	}
	@Extension
	public static class DescriptorImpl extends UserPropertyDescriptor {
		@Override
		public UserProperty newInstance(User user) {
			return new FavoriteViewsUserProperty();
		}
		@Override
		public String getDisplayName() {
			return "Favorite Views";
		}
	}
}