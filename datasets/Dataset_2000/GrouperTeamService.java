public interface GrouperTeamService extends GrouperDao {
  
  Team findTeamById(String teamId);
  
  String addTeam(String teamId, String displayName, String teamDescription,
      String stemName) throws DuplicateTeamException;
  
  void updateTeam(String teamId, String displayName, String teamDescription, String actAsSubject);
  
  void deleteTeam(String teamId);
  
  void deleteMember(String teamId, String personId);
  
  void setVisibilityGroup(String teamId, boolean viewable);
  
  boolean addMemberRole(String teamId, String memberId, Role role,
                        String actAsUserId);
  
  boolean removeMemberRole(String teamId, String memberId, Role role,
                           String actAsUserId);
  
  void addMember(String teamId, Person person);
  
  Member findMember(String teamId, String memberId);
  
  Set<Member> findAdmins(Team team);
  
  public boolean doesStemExists(String stemName);
  Stem findStem(String stemId);
}