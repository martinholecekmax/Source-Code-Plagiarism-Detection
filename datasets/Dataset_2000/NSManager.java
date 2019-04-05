public final class NSManager {
    private final Map<String, String> cache = new HashMap<String, String>();
    public NSManager() {
        resolveConstants(JAXWSAConstants.class);
        resolveConstants(WSDLConstants.class);
    }
    private void resolveConstants(final Class<?> clz) {
        for (Field field : clz.getFields()) {
            if (field.getName().endsWith("_PREFIX") && isPulicStaticFinal(field)) {
                try {
                    String prefix = (String) field.get(clz);
                    Field nsField = clz.getField("NS_" + prefix.toUpperCase());
                    if (nsField != null) {
                        cache.put((String)nsField.get(clz), prefix);
                    }
                } catch (Exception e) {
                                    }
            }
        }
    }
    public String getPrefixFromNS(String namespace) {
        return cache.get(namespace);
    }
    private boolean isPulicStaticFinal(final Field field) {
        return field.getModifiers() == (Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL);
    }
    public Set<String> getNamespaces() {
        return this.cache.keySet();
    }
}