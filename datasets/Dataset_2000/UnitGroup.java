@JsonIgnoreProperties(ignoreUnknown = true)
public class UnitGroup {
    @JsonProperty("t")
    public int type;
    @JsonProperty("c")
    public int count;
    @JsonProperty("tc")
    public int totalCount;
}