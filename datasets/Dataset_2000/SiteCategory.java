public class SiteCategory {
	private static Comparator<SiteCategory> comp;
	private String description;
	private String label;
	private String name;
	private Map<Locale, Map<String, String>> localizations;
	
	public static Comparator<SiteCategory> getComparator() {
		if (comp == null) {
			comp = new Comparator<SiteCategory>() {
				
				public int compare(SiteCategory cat1, SiteCategory cat2) {
					if (cat1.equals(cat2))
						return 0;
					return cat1.getName().compareTo(cat2.getName());
				}
			};
		}
		return comp;
	}
	
	public SiteCategory() {
		super();
	}
	
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof SiteCategory) {
			SiteCategory otherCategory = (SiteCategory) obj;
			result = getName().equalsIgnoreCase(otherCategory.getName());
		}
		return result;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Map<Locale, Map<String, String>> getLocalizations() {
		return this.localizations;
	}
	
	public String getName() {
		return name;
	}
	
	public int hashCode() {
		return getName().hashCode();
	}
	
	public void resolve(URL base, URL bundleURL) throws MalformedURLException {
									}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setLocalizations(Map<Locale, Map<String, String>> localizations) {
		this.localizations = localizations;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}