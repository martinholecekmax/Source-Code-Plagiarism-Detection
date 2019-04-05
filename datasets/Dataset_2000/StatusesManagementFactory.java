public class StatusesManagementFactory extends AbstractResourceFactory {
    protected void doQualifyNames(ProbeInfoImpl info) {
        info.setShortcutName(info.getDescriptor().getShortcut());
        info.setQualifiedName(info.getDescriptor().getQualifiedName());
        if (info.getQualifiedName() == null) {
            info.setQualifiedName(ObjectNameFactory.formatQualifiedName(CoreManagementComponent.NAME)
                    + ",status=probes,probe=" + info.getShortcutName());
        }
    }
    @Override
    public void registerResources() {
        AdministrativeStatusManagerImpl adminStatus = Framework.getLocalService(AdministrativeStatusManagerImpl.class);
        service.registerResource(
                "adminStatus",
                ObjectNameFactory.formatQualifiedName(CoreManagementComponent.NAME)
                        + ",status=administrative",
                AdministrativeStatusManagerImpl.class, adminStatus);
        ProbeManager runner = Framework.getLocalService(ProbeManager.class);
        service.registerResource(
                "probeStatus",
                ObjectNameFactory.formatQualifiedName(CoreManagementComponent.NAME)
                        + ",status=probes", ProbeManagerImpl.class, runner);
        for (ProbeInfo info : runner.getAllProbeInfos()) {
            doQualifyNames((ProbeInfoImpl) info);
            service.registerResource(info.getShortcutName(),
                    info.getQualifiedName(), ProbeInfoImpl.class, info);
        }
    }
}