@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usage_type", propOrder = {
    "job"
})
public class UsageType  implements Serializable {
    protected List<JobType> job;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cpucount;
    @XmlAttribute
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger cpupernode;
    
    public List<JobType> getJob() {
        if (job == null) {
            job = new ArrayList<JobType>();
        }
        return this.job;
    }
    
    public BigInteger getCpucount() {
        return cpucount;
    }
    
    public void setCpucount(BigInteger value) {
        this.cpucount = value;
    }
    
    public BigInteger getCpupernode() {
        if (cpupernode == null) {
            return new BigInteger("1");
        } else {
            return cpupernode;
        }
    }
    
    public void setCpupernode(BigInteger value) {
        this.cpupernode = value;
    }
}