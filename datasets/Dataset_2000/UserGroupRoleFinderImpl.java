public class UserGroupRoleFinderImpl
	extends BasePersistenceImpl<UserGroupRole> implements UserGroupRoleFinder {
	public static String FIND_BY_USER_USER_GROUP_GROUP_ROLE =
		UserGroupRoleFinder.class.getName() + ".findByUserUserGroupGroupRole";
	public List<UserGroupRole> findByUserUserGroupGroupRole(
			long userId, long groupId)
		throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_USER_USER_GROUP_GROUP_ROLE);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("UserGroupRole", UserGroupRoleImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(userId);
			qPos.add(groupId);
			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}