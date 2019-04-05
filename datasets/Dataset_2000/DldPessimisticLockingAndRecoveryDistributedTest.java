@Test(groups = "functional", testName = "tx.recovery.DldEagerLockingAndRecoveryDistributedTest")
public class DldPessimisticLockingAndRecoveryDistributedTest extends DldPessimisticLockingDistributedTest {
   @Override
   protected Configuration createConfiguration() {
      return super.createConfiguration().fluent().transaction().recovery().build();
   }
}