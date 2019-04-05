public class IvyLoader extends JarListLoader {
  private static final Logger log
    = Logger.getLogger(IvyLoader.class.getName());
  private IvyManager _manager = new IvyManager();
    private Path _ivyFile;
    private ArrayList<IvyDependency> _dependencyList
    = new ArrayList<IvyDependency>();
    private ArrayList<Path> _pathList = new ArrayList<Path>();
  
  public IvyLoader()
  {
  }
  
  public void setIvyFile(Path path)
  {
    _ivyFile = path;
  }
  
  public Path getIvyFile()
  {
    return _ivyFile;
  }
  
  public IvyCache createCache()
  {
    return _manager.createCache();
  }
  
  public void addDependency(IvyDependency dependency)
  {
    _dependencyList.add(dependency);
  }
  
  @PostConstruct
  @Override
  public void init()
    throws ConfigException
  {
    _manager.init();
    if (_ivyFile != null && _ivyFile.canRead()) {
      _manager.configureIvyFile(_ivyFile);
    }
    for (IvyDependency dependency : _dependencyList) {
      _manager.resolve(dependency);
    }
    for (Path path : _manager.resolve()) {
      if (log.isLoggable(Level.FINE))
        log.fine("ivy-loader add " + path);
      addJar(path);
    }
    super.init();
  }
  
  public boolean isModified()
  {
    return false;
  }
  
  public boolean logModified(Logger log)
  {
    if (isModified()) {
      log.info(_ivyFile.getNativePath() + " has modified jar files");
      return true;
    }
    else
      return false;
  }
  
  private void fillJars()
  {
    _pathList.clear();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "[" + _ivyFile + "]";
  }
}