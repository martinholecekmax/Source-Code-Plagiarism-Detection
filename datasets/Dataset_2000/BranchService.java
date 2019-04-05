public interface BranchService extends EntityService<PoulpeBranch> {
    
    List<PoulpeBranch> getAll();
    
    void saveBranch(PoulpeBranch selectedBranch);
    
    void deleteBranchRecursively(PoulpeBranch victim);
    
    void deleteBranchMovingTopics(PoulpeBranch victim, PoulpeBranch recipient);
    
    PermissionsMap<BranchPermission> getPermissionsFor(PoulpeBranch branch);
    
    void changeGrants(PoulpeBranch branch, PermissionChanges changes);
    
    void changeRestrictions(PoulpeBranch branch, PermissionChanges changes);
}