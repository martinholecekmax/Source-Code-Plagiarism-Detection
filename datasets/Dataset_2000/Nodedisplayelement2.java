@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodedisplayelement2", propOrder = {
    "el3"
})
public class Nodedisplayelement2
    extends Nodedisplayelement
 implements Serializable {
    protected List<Nodedisplayelement3> el3;
    
    public List<Nodedisplayelement3> getEl3() {
        if (el3 == null) {
            el3 = new ArrayList<Nodedisplayelement3>();
        }
        return this.el3;
    }
}