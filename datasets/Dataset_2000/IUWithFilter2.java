public class IUWithFilter2 extends AbstractProvisioningTest {
	IInstallableUnit a1, a2;
	IInstallableUnit b1;
	IPlanner planner;
	IProfile profile;
	protected void setUp() throws Exception {
		super.setUp();
		IRequirement[] reqs = new IRequirement[1];
		reqs[0] = MetadataFactory.createRequirement(IInstallableUnit.NAMESPACE_IU_ID, "B", new VersionRange("[1.0.0, 1.0.0]"), null, false, false);
		a1 = createIU("A", reqs);
		IRequirement[] reqsA2 = new IRequirement[1];
		reqsA2[0] = MetadataFactory.createRequirement(IInstallableUnit.NAMESPACE_IU_ID, "B", new VersionRange("[1.0.0, 1.0.0]"), null, true, false);
		a2 = createIU("A", reqsA2);
		b1 = createIU("B", Version.create("1.0.0"), "(invalid=true)", NO_PROVIDES);
		createTestMetdataRepository(new IInstallableUnit[] {a1, a2, b1});
		profile = createProfile(IUWithFilter2.class.getName());
		planner = createPlanner();
	}
	public void testInstallA1() {
		ProfileChangeRequest req = new ProfileChangeRequest(profile);
		req.addInstallableUnits(new IInstallableUnit[] {a1});
		assertEquals(IStatus.ERROR, planner.getProvisioningPlan(req, null, null).getStatus().getSeverity());
	}
	public void testInstallA2() {
		ProfileChangeRequest req = new ProfileChangeRequest(profile);
		req.addInstallableUnits(new IInstallableUnit[] {a2});
		assertEquals(IStatus.OK, planner.getProvisioningPlan(req, null, null).getStatus().getSeverity());
	}
}