public class FXGraphUiInjectorProvider implements IInjectorProvider {
	public Injector getInjector() {
		return at.bestsolution.efxclipse.tooling.fxgraph.ui.internal.FXGraphActivator.getInstance().getInjector("at.bestsolution.efxclipse.tooling.fxgraph.FXGraph");
	}
}