public interface ProgramRunner<Settings extends JDOMExternalizable> {
  ExtensionPointName<ProgramRunner> PROGRAM_RUNNER_EP = ExtensionPointName.create("com.intellij.programRunner");
  interface Callback {
    void processStarted(RunContentDescriptor descriptor);
  }
  @NotNull @NonNls
  String getRunnerId();
  boolean canRun(@NotNull final String executorId, @NotNull final RunProfile profile);
  @Nullable
  Settings createConfigurationData(ConfigurationInfoProvider settingsProvider);
  void checkConfiguration(RunnerSettings settings, ConfigurationPerRunnerSettings configurationPerRunnerSettings)
    throws RuntimeConfigurationException;
  void onProcessStarted(RunnerSettings settings, ExecutionResult executionResult);
  AnAction[] createActions(ExecutionResult executionResult);
  @Nullable
  SettingsEditor<Settings> getSettingsEditor(Executor executor, RunConfiguration configuration);
  void execute(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException;
  void execute(@NotNull Executor executor, @NotNull ExecutionEnvironment environment, @Nullable Callback callback) throws ExecutionException;
}