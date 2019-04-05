public interface JDBCEntityPersistenceStore {
    
    Object createBeanClassInstance() throws Exception;
    
    void initEntity(CmpEntityBeanContext ctx);
    
    Object createEntity(Method m, Object[] args, CmpEntityBeanContext instance) throws Exception;
    
    Object postCreateEntity(Method m, Object[] args, CmpEntityBeanContext instance)
            throws Exception;
    
    Object findEntity(Method finderMethod, Object[] args, CmpEntityBeanContext instance, final JDBCQueryCommand.EntityProxyFactory factory) throws Exception;
    
    Collection findEntities(Method finderMethod, Object[] args, CmpEntityBeanContext instance, final JDBCQueryCommand.EntityProxyFactory factory) throws Exception;
    
    void activateEntity(CmpEntityBeanContext instance)
            throws RemoteException;
    
    void loadEntity(CmpEntityBeanContext instance)
            throws RemoteException;
    
    boolean isStoreRequired(CmpEntityBeanContext instance) throws Exception;
    
    boolean isModified(CmpEntityBeanContext instance) throws Exception;
    
    void storeEntity(CmpEntityBeanContext instance)
            throws RemoteException;
    
    void passivateEntity(CmpEntityBeanContext instance)
            throws RemoteException;
    
    void removeEntity(CmpEntityBeanContext instance)
            throws RemoteException, RemoveException;
    JDBCAbstractEntityBridge getEntityBridge();
    JDBCEntityMetaData getMetaData();
    JDBCTypeFactory getJDBCTypeFactory();
    CmpEntityBeanComponent getComponent();
    Catalog getCatalog();
    CmpConfig getCmpConfig();
    DataSource getDataSource(String name);
    boolean hasCreateTable(String entityName);
    void addCreateTable(String entityName);
    void addExistingTable(String entityName);
    EntityBridgeInvocationHandler getInvocationHandler();
    KeyGeneratorFactory getKeyGeneratorFactory(String name);
}