public class ItemBagFamilyEntry extends DBCStruct<ItemBagFamilyEntry> {
    @XmlAttribute(name = "id", required = true)
    public final Unsigned32 id = new Unsigned32();
    @XmlAttribute(name = "name")
    public final MultiInternalString name = new MultiInternalString();
}