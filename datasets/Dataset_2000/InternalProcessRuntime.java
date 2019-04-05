public interface InternalProcessRuntime extends org.drools.runtime.process.InternalProcessRuntime {
	ProcessInstanceManager getProcessInstanceManager();
	SignalManager getSignalManager();
	TimerManager getTimerManager();
	ProcessEventSupport getProcessEventSupport();
}