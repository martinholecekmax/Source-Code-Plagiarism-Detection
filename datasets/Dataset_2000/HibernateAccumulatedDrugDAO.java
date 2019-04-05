public class HibernateAccumulatedDrugDAO implements AccumulatedDrugDAO {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public AccumulatedDrug getAccumulatedDrug(Integer id) {
        return (AccumulatedDrug) sessionFactory.getCurrentSession().get(AccumulatedDrug.class, id);
    }
    public AccumulatedDrug saveAccumulatedDrug(AccumulatedDrug ad) {
        sessionFactory.getCurrentSession().saveOrUpdate(ad);
        return ad;
    }
}