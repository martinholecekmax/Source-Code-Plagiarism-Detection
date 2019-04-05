public abstract class CompilerStageEZ extends CompilerStage {
    
    public CompilerStageEZ(String name) { super(name); }
    public List<Option> getOptions() {
	return Collections.EMPTY_LIST;     }
    protected abstract void real_action();
    public final CompilerState action(CompilerState cs) {
	_UNPACK_CS(cs);
	real_action();
	return _PACK_CS();
    }
    protected CompilerState old_cs;
    protected HMethod mainM;
    protected Set roots;
    protected Linker linker;
    protected HCodeFactory hcf;
    protected ClassHierarchy classHierarchy;
    protected Frame frame;
    protected PersistentMap<String,Object> attribs;
    protected final void _UNPACK_CS(CompilerState cs) {
	this.old_cs = cs;
	this.mainM = cs.getMain();
	this.roots = cs.getRoots();
	this.linker = cs.getLinker();
	this.hcf = cs.getCodeFactory();
	this.classHierarchy = cs.getClassHierarchy();
	this.frame = cs.getFrame();
	this.attribs = cs.getAttributes();
    }
    protected final CompilerState _PACK_CS() {
	CompilerState new_cs = 
	    old_cs
	    .changeMain(mainM)
	    .changeRoots(roots)
	    .changeLinker(linker)
	    .changeCodeFactory(hcf)
	    .changeClassHierarchy(classHierarchy)
	    .changeFrame(frame)
	    .changeAttributes(attribs);
	mainM = null;
	roots = null;
	linker = null;
	hcf = null;
	classHierarchy = null;
	frame = null;
	attribs = null;
	return new_cs;
    }
}