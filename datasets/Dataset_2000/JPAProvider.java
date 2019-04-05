public enum JPAProvider {
    
    HIBERNATE("org.hibernate.Session", new HQLTemplates()),
    
    ECLIPSELINK("org.eclipse.persistence.jpa.JpaEntityManager", new EclipseLinkTemplates()),
    
    OPEN_JPA("org.apache.openjpa.persistence.OpenJPAEntityManager", new OpenJPATemplates()),
    
    GENERIC("javax.persistence.EntityManager", JPQLTemplates.DEFAULT); 
    private Class<?> delegateClass;
    private final JPQLTemplates templates;
    JPAProvider(String emClassName, JPQLTemplates templates) {
        this.templates = templates;
        try {            
            this.delegateClass = Class.forName(emClassName);            
        } catch (ClassNotFoundException e) {}
    }
    public JPQLTemplates getTemplates() {
        return templates;
    }
    public static JPAProvider get(EntityManager em) {
        for (JPAProvider provider : values()) {
            if (provider.delegateClass != null 
             && provider.delegateClass.isAssignableFrom(em.getDelegate().getClass())) {
                return provider;
            }
        }       
        throw new IllegalStateException("No Provider for " + em.getClass().getName());
    }
    public static JPQLTemplates getTemplates(EntityManager em) {
        return get(em).getTemplates();
    }
}