public abstract class VendorBean implements EntityBean {
    private EntityContext context;
    
    public void setEntityContext(EntityContext aContext) {
        context = aContext;
    }
    
    public void ejbActivate() {
    }
    
    public void ejbPassivate() {
    }
    
    public void ejbRemove() {
    }
    
    public void unsetEntityContext() {
        context = null;
    }
    
    public void ejbLoad() {
    }
    
    public void ejbStore() {
    }
    public abstract int getVendorId();
    public abstract void setVendorId(int vendorId);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract String getAddress();
    public abstract void setAddress(String address);
    public abstract String getContact();
    public abstract void setContact(String contact);
    public abstract String getPhone();
    public abstract void setPhone(String phone);
    public abstract Collection getVendorParts();
    public abstract void setVendorParts(Collection vendorParts);
    public VendorKey ejbCreate(int vendorId, String name, String address,
        String contact, String phone) throws CreateException {
        setVendorId(vendorId);
        setName(name);
        setAddress(address);
        setContact(contact);
        setPhone(phone);
        return null;
    }
    public void ejbPostCreate(int vendorId, String name, String address,
        String contact, String phone) throws CreateException {
    }
    public void addVendorPart(LocalVendorPart part) {
        getVendorParts()
            .add(part);
    }
}