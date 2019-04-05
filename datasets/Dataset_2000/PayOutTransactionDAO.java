public class PayOutTransactionDAO extends BasePayOutTransactionDAO {
	
	public PayOutTransactionDAO () {}
	public void saveTransaction(PayOutTransaction t, Terminal terminal) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = createNewSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(t);
			session.saveOrUpdate(terminal);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			}catch(Exception x) {}
			throw e;
		} finally {
			closeSession(session);
		}
	}
	public List<PayOutTransaction> getUnsettled(Terminal terminal) {
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(getReferenceClass());
			criteria.add(Restrictions.eq(PayOutTransaction.PROP_DRAWER_RESETTED, Boolean.FALSE));
			criteria.add(Restrictions.eq(PayOutTransaction.PROP_TERMINAL, terminal));
			List list = criteria.list();
			return list;
		} finally {
			closeSession(session);
		}
	}
}