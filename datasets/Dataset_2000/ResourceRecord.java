public class ResourceRecord {
    private String m_name;
    private String m_rClass;
    private Integer m_rdLength;
    private String m_rdata;
    private String m_ttl;
    
    public String getName() {
        return m_name;
    }
    
    public void setName(String name) {
        m_name = name;
    }
    
    public String getRClass() {
        return m_rClass;
    }
    
    public void setClass(String class1) {
        m_rClass = class1;
    }
    
    public Integer getRdLength() {
        return m_rdLength;
    }
    
    public void setRdLength(Integer rdLength) {
        m_rdLength = rdLength;
    }
    
    public String getRdata() {
        return m_rdata;
    }
    
    public void setRdata(String rdata) {
        m_rdata = rdata;
    }
    
    public String getTtl() {
        return m_ttl;
    }
    
    public void setTtl(String ttl) {
        m_ttl = ttl;
    }
}