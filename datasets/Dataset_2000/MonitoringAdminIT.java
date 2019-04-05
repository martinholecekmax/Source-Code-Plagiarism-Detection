public class MonitoringAdminIT {
    private MonitoringAdmin cut;
    @Before
    public void init(){
        this.cut = new MonitoringAdmin();
        this.cut.location = "localhost:4848";
        this.cut.initializeClient();
    }
    @Test
    public void activateMonitoring() {
        assertTrue(this.cut.activateMonitoring());
    }
    @Test
    public void deactivateMonitoring() {
        assertTrue(this.cut.deactivateMonitoring());
    }
}