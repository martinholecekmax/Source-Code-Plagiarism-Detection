public class SharedConcepts_Language {
  public static ModuleReference MODULE_REFERENCE = ModuleReference.fromString("13744753-c81f-424a-9c1b-cf8943bf4e86(jetbrains.mps.lang.sharedConcepts)");
  public static Language get() {
    return (Language) MPSModuleRepository.getInstance().getModule(MODULE_REFERENCE);
  }
}