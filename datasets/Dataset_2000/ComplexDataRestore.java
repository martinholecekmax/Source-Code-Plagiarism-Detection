public class ComplexDataRestore implements DataRestore
{
   
   private List<DataRestore> restorers = new ArrayList<DataRestore>();
   
   public ComplexDataRestore(List<DataRestore> restorers)
   {
      this.restorers.addAll(restorers);
   }
   
   public void clean() throws BackupException
   {
      for (DataRestore restorer : restorers)
      {
         restorer.clean();
      }
   }
   
   public void restore() throws BackupException
   {
      for (DataRestore restorer : restorers)
      {
         restorer.restore();
      }
   }
   
   public void commit() throws BackupException
   {
      for (DataRestore restorer : restorers)
      {
         restorer.commit();
      }
   }
   
   public void rollback() throws BackupException
   {
      for (DataRestore restorer : restorers)
      {
         restorer.rollback();
      }
   }
   
   public void close() throws BackupException
   {
      try
      {
         for (DataRestore restorer : restorers)
         {
            restorer.close();
         }
      }
      finally
      {
         restorers.clear();
      }
   }
}