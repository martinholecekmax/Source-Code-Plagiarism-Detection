public final class NameDictionary {
	public static final boolean isDefaultAgentName(String name) { 
		return Agent.DEFAULT_NAME.equals(name);
	}
	public static final boolean isDefaultSiteName(String name) { 
		return Site.DEFAULT_NAME.equals(name);
	}
	public static final boolean isDefaultInternalStateName(String name) { 
		return InternalState.DEFAULT_NAME.equals(name);
	}
}