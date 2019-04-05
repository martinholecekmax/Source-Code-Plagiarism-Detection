public class AgentDAO extends JpaTemplate<Agent,Long> implements IAgentDAO {
    public boolean exists(Long id) {
        Query query = HibernateUtil.getSession()
            .createQuery("from Agent agent where agent.id = :id ")
            .setLong("id", id.longValue());
        return query.uniqueResult() != null;
    }
    public Agent findByLogin(final String login) {
        Query query = HibernateUtil.getSession()
            .createQuery("from Agent agent where agent.login = :login ")
            .setString("login", login);
        return (Agent) query.uniqueResult(); 
    }
    public List listAll() {
        StringBuffer sb = new StringBuffer();
        sb.append("from Agent as agent order by agent.lastName asc");
        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }
}