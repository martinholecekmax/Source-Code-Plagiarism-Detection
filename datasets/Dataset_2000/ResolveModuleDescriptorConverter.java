public class ResolveModuleDescriptorConverter implements ModuleDescriptorConverter {
    private final ModuleDescriptorFactory moduleDescriptorFactory;
    private final ConfigurationsToModuleDescriptorConverter configurationsToModuleDescriptorConverter;
    private final DependenciesToModuleDescriptorConverter dependenciesToModuleDescriptorConverter;
    public ResolveModuleDescriptorConverter(ModuleDescriptorFactory moduleDescriptorFactory,
                                            ConfigurationsToModuleDescriptorConverter configurationsToModuleDescriptorConverter,
                                            DependenciesToModuleDescriptorConverter dependenciesToModuleDescriptorConverter) {
        this.moduleDescriptorFactory = moduleDescriptorFactory;
        this.configurationsToModuleDescriptorConverter = configurationsToModuleDescriptorConverter;
        this.dependenciesToModuleDescriptorConverter = dependenciesToModuleDescriptorConverter;
    }
    public ModuleDescriptor convert(Set<? extends Configuration> configurations, Module module) {
        assert configurations.size() > 0 : "No configurations found for module: " + module.getName() + ". Configure them or apply a plugin that does it.";
        DefaultModuleDescriptor moduleDescriptor = moduleDescriptorFactory.createModuleDescriptor(module);
        configurationsToModuleDescriptorConverter.addConfigurations(moduleDescriptor, configurations);
        dependenciesToModuleDescriptorConverter.addDependencyDescriptors(moduleDescriptor, configurations);
        return moduleDescriptor;
    }
}