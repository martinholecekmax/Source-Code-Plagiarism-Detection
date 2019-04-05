public class NotificationDao extends StudyCalendarMutableDomainObjectDao<Notification> implements DeletableDomainObjectDao<Notification> {
    @Override
    public Class<Notification> domainClass() {
        return Notification.class;
    }
    public void save(final Notification notification) {
    }
    
    public void delete(Notification notification) {
        getHibernateTemplate().delete(notification);
    }
    public void deleteAll(List<Notification> t) {
        getHibernateTemplate().deleteAll(t);
    }
}