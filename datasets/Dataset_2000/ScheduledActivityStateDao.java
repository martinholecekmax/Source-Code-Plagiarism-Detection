public class ScheduledActivityStateDao extends StudyCalendarMutableDomainObjectDao<ScheduledActivityState> implements DeletableDomainObjectDao<ScheduledActivityState> {
    @Override public Class<ScheduledActivityState> domainClass() { return ScheduledActivityState.class;}
    public void delete(ScheduledActivityState scheduledActivityState) {
        getHibernateTemplate().delete(scheduledActivityState);
    }
    public void deleteAll(List<ScheduledActivityState> scheduledActivityStates) {
        getHibernateTemplate().deleteAll(scheduledActivityStates);
    }
}