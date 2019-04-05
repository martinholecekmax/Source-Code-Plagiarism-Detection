public class FigureLibrary {
	IValueFactory values;
	public FigureLibrary(IValueFactory values) {
		this.values = values;
	}
	public void renderActual(IString name, IConstructor fig, IEvaluatorContext ctx) {
		FigureViewer.open(name, fig, ctx);
	}
	public void renderSaveActual(final IConstructor cfig, final ISourceLocation loc, final IEvaluatorContext ctx) {
		renderSaveActual(cfig,null,null,loc,ctx);
	}
	public void renderSaveActual(final IConstructor cfig, final IInteger width, final IInteger height, final ISourceLocation loc, final IEvaluatorContext ctx) {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				final Shell shell = new Shell(PlatformUI.getWorkbench().getDisplay());
				final FigureExecutionEnvironment env = new FigureExecutionEnvironment(shell, cfig, ctx);
				shell.getDisplay().asyncExec(new Runnable() {
					@Override
					public void run() {
						OutputStream out = null;
						try{
							out =  ctx.getResolverRegistry().getOutputStream(loc.getURI(), false);
							env.writeScreenshot(out);
						} catch(IOException f){
							ctx.getStdErr().printf("Could not save figure " + f.getMessage() + "\n");
						} finally{
							if(out != null){
								try{
									out.close();
								}catch(IOException ioex){
																	}
							}
							env.dispose();
							shell.close();
							shell.dispose();
						}
					}
				});
				BoundingBox minViewSize = env.getMinViewingSize();
				int w,h;
				w = (int)minViewSize.getX();
				h = (int)minViewSize.getY();
				if(width != null){
					w = Math.max(w,width.intValue());
				}
				if(height != null){
					h = Math.max(h,height.intValue());
				}
				w += 10; 				h += 10;
				Rectangle r = shell.computeTrim(0, 0, w, h);
				shell.setBounds(r);
				env.setSize(w,h);
				shell.open();
							}
		});
	}
}