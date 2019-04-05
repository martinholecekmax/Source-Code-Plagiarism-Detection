public class Bug311330 extends AbstractProvisioningTest {
	public void testValidateProfile() throws ProvisionException {
		IProvisioningAgentProvider provider = getAgentProvider();
		IProvisioningAgent agent = provider.createAgent(getTestData("bug311330 data", "testData/bug311330/p2").toURI());
		IPlanner planner = (IPlanner) agent.getService(IPlanner.SERVICE_NAME);
		IProfile sdkProfile = ((IProfileRegistry) agent.getService(IProfileRegistry.SERVICE_NAME)).getProfile("SDKProfile");
		IProfileChangeRequest request = planner.createChangeRequest(sdkProfile);
		assertFalse("rap.jface not found", sdkProfile.available(QueryUtil.createIUQuery("org.eclipse.rap.jface"), null).isEmpty());
				RequiredCapability req1 = new RequiredCapability(IInstallableUnit.NAMESPACE_IU_ID, "org.eclipse.rap.jface", new VersionRange("[1.1.0, 1.4.0)"), null, 0, 0, false, null);
		ArrayList<IRequirement> reqs = new ArrayList();
		reqs.add(req1);
		request.addExtraRequirements(reqs);
		ProvisioningContext pc = new ProvisioningContext(agent);
		pc.setMetadataRepositories(new URI[0]);
		pc.setArtifactRepositories(new URI[0]);
		IProvisioningPlan plan = planner.getProvisioningPlan(request, pc, new NullProgressMonitor());
		assertFalse("should remove rap.jface", plan.getRemovals().query(QueryUtil.createIUQuery("org.eclipse.rap.jface"), null).isEmpty());
		assertOK("plan is not ok", plan.getStatus());
	}
}