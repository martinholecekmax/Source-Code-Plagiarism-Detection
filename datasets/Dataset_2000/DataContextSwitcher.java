public class DataContextSwitcher
	extends EmittableComponent
{
	private final Integer id;
	public DataContextSwitcher(Integer id)
	{
		super("dataSwitch", null);
		this.id = id;
	}
	@Override
	public String getName()
	{
		return super.getName() + "[" + id + "]";
	}
	@Override
	public Content copy()
	{
		return new DataContextSwitcher(id);
	}
	@Override
	public void emit(Emitter emitter, RenderingContext ctx, TemplateOutputStream out)
		throws IOException
	{
		Integer old = emitter.switchData(id);
		for(Content c : getRawContents())
		{
			emitter.emit(out, c);
		}
		emitter.switchData(old);
	}
	@Override
	public String toString()
	{
		return "DataSwitch[id=" + id + ", identity=" + System.identityHashCode(this) + ", path=" + getPath() + "]";
	}
}