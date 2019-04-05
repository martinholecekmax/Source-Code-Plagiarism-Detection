@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressListResponse", propOrder = {
        "addressList"
})
public class AddressListResponse extends Response {
    List<Address> addressList;
    public AddressListResponse() {
        super();
            }
    public AddressListResponse(ResponseStatus s) {
        super(s);
            }
    public List<Address> getAddressList() {
        return addressList;
    }
    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}