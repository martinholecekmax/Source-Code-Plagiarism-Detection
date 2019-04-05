public class UserTransactionFactory implements ObjectFactory {
    public Object getObjectInstance(Object object, Name name, Context context, Hashtable environment) throws Exception {
                TransactionManager transactionManager = SystemInstance.get().getComponent(TransactionManager.class);
        if (transactionManager == null) {
            throw new NamingException("transaction manager not found");
        }
                if (transactionManager instanceof UserTransaction) {
            return transactionManager;
        }
                return new CoreUserTransaction(transactionManager);
    }
}