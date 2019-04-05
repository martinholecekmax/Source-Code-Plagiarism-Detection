public class WmiParams {
    
    public final static String WMI_OPERATION_INSTANCEOF = "InstanceOf";
    
    public final static String WMI_OPERATION_WQL = "Wql";
    
	private Object m_CompareValue = null;
	private String m_CompareOperation = null;
	private String m_WmiClass = null;
	private String m_WmiObject = null;
    private String m_WmWqlStr = null;
    private String m_WmiOperation = null;
	
	public WmiParams(final String queryType, final Object compVal, final String compOp, final String wmiObj1, final String wmiObj2) {
		m_CompareValue = compVal;
		m_CompareOperation = compOp;
        if(queryType.equals(WMI_OPERATION_INSTANCEOF)) {
            m_WmiClass = wmiObj1;
        } else {
            m_WmWqlStr = wmiObj1;
        }
        m_WmiObject = wmiObj2;
        m_WmiOperation = queryType;
    }
    @SuppressWarnings("unused")
    private WmiParams() {
			}
	
	public Object getCompareValue() {
		return m_CompareValue;
	}
	
	public void setCompareValue(final Object compareValue) {
		m_CompareValue = compareValue;
	}
	
	public String getCompareOperation() {
		return m_CompareOperation;
	}
	
	public void setCompareOperation(final String compareOperation) {
		m_CompareOperation = compareOperation;
	}
	
	public String getWmiClass() {
		return m_WmiClass;
	}
	
	public void setWmiClass(final String wmiClass) {
		m_WmiClass = wmiClass;
	}
	
	public String getWmiObject() {
		return m_WmiObject;
	}
	
	public void setWmiObject(final String wmiObject) {
		m_WmiObject = wmiObject;
	}
    
    public String getWql() {
        return m_WmWqlStr;
    }
    
    public void setWql(final String wmiWql) {
        this.m_WmWqlStr = wmiWql;
    }
    
    public String getWmiOperation() {
        return m_WmiOperation;
    }
    
    public void setWmiOperation(final String wmiOperation) {
        this.m_WmiOperation = wmiOperation;
    }
}