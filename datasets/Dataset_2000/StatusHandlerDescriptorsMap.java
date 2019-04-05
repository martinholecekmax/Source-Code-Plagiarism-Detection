class StatusHandlerDescriptorsMap {
	private final String ASTERISK = "*"; 	private HashMap map;
	
	public StatusHandlerDescriptorsMap() {
		map = new HashMap();
	}
	
	public void addHandlerDescriptor(StatusHandlerDescriptor handlerDescriptor) {
		add(this.map, handlerDescriptor.getPrefix(), handlerDescriptor);
	}
	
	private void add(Map map, String prefix,
			StatusHandlerDescriptor handlerDescriptor) {
		if (prefix == null) {
			if (map.get(ASTERISK) == null) {
				map.put(ASTERISK, new ArrayList());
			}
			((List) map.get(ASTERISK)).add(handlerDescriptor);
		} else {
			int delimIndex = prefix.indexOf("."); 			String pre = null;
			String post = null;
			if (delimIndex != -1) {
				pre = prefix.substring(0, delimIndex);
				if (delimIndex < prefix.length() - 1) {
					post = prefix.substring(delimIndex + 1);
				}
			} else {
				pre = prefix;
			}
			if (map.get(pre) == null) {
				map.put(pre, new HashMap());
			}
			add((Map) map.get(pre), post, handlerDescriptor);
		}
	}
	public void clear() {
		map.clear();
	}
	
	public List getHandlerDescriptors(String pluginId) {
		return get(pluginId, this.map);
	}
	
	private List get(String pluginId, Map map) {
		if (pluginId == null) {
			return getAsteriskList(map);
		}
		int delimIndex = pluginId.indexOf("."); 		String pre = null;
		String post = null;
		if (delimIndex != -1) {
			pre = pluginId.substring(0, delimIndex);
			if (delimIndex < pluginId.length() - 1) {
				post = pluginId.substring(delimIndex + 1);
			}
		} else {
			pre = pluginId;
		}
		if (map.get(pre) == null) {
			return getAsteriskList(map);
		}
		return get(post, (Map) map.get(pre));
	}
	private List getAsteriskList(Map map) {
		Object list = map.get(ASTERISK);
		if (list != null) {
			return (List) list;
		}
		return null;
	}
}