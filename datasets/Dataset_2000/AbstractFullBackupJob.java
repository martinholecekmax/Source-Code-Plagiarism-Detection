public abstract class AbstractFullBackupJob extends AbstractBackupJob
{
   public AbstractFullBackupJob()
   {
      this.id = 0;
      notifyListeners();
   }
   public final int getType()
   {
      return FULL;
   }
}