@Ds(entity = ElementType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ElementTypeLovDs.fNAME) })
public class ElementTypeLovDs extends AbstractTypeLov<ElementType> {
    public static final String fENGINEID = "engineId";
    public static final String fENGINE = "engine";
    public static final String fENGINETYPE = "engineType";
    @DsField(join = "left", path = "engine.id")
    private Long engineId;
    @DsField(join = "left", path = "engine.name")
    private String engine;
    @DsField(join = "left", path = "engine.type")
    private String engineType;
    public ElementTypeLovDs() {
        super();
    }
    public ElementTypeLovDs(ElementType e) {
        super(e);
    }
    public Long getEngineId() {
        return this.engineId;
    }
    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }
    public String getEngine() {
        return this.engine;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }
    public String getEngineType() {
        return this.engineType;
    }
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}