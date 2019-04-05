public class BranchConverter extends AbstractConverter {
	@Override
	public VersionSelector createSelector(Version version) throws CoreException {
		if (version == null)
			return null;
		String selectorComponent = createSelectorComponent(version);
		return selectorComponent == null ? null : VersionSelector.branch(selectorComponent);
	}
	@Override
	public Version createVersion(VersionSelector versionSelector) throws CoreException {
		if (versionSelector == null)
			return null;
		String name = versionSelector.getName();
		if (name.equals(VersionSelector.DEFAULT_BRANCH))
			return null;
		return createVersionFromSelectorComponent(name);
	}
	@Override
	public int getSelectorType() {
		return VersionSelector.BRANCH;
	}
	@Override
	protected IVersionFormat getDefaultVersionFormat() {
		try {
			return Version.compile("S"); 		} catch (VersionFormatException e) {
			return null;
		}
	}
}