public class NameAddress {
	String name;
	SipURL url;
	public NameAddress(String displayname, SipURL sipurl) {
		name = displayname;
		url = sipurl;
	}
	public NameAddress(SipURL sipurl) {
		name = null;
		url = sipurl;
	}
	public NameAddress(NameAddress name_address) {
		name = name_address.getDisplayName();
		url = name_address.getAddress();
	}
	public NameAddress(String naddr) {
		SipParser par = new SipParser(naddr);
		NameAddress na = par.getNameAddress();
														name = na.name;
		url = na.url;
	}
	
	public Object clone() {
		return new NameAddress(this);
	}
	
	public boolean equals(Object obj) {
		NameAddress naddr = (NameAddress) obj;
		return url.equals(naddr.getAddress());
	}
	
	public SipURL getAddress() {
		return url;
	}
	
	public String getDisplayName() {
		return name;
	}
	
	public boolean hasDisplayName() {
		return name != null;
	}
	
	public void removeDisplayName() {
		name = null;
	}
	
	public void setAddress(SipURL address) {
		url = address;
	}
	
	public void setDisplayName(String displayName) {
		name = displayName;
	}
	
	public boolean equals(NameAddress naddr) {
		return (name == naddr.name && url == naddr.url);
	}
	
	public String toString() {
		String str;
		if (hasDisplayName())
			str = "\"" + name + "\" <" + url + ">";
		else
			str = "<" + url + ">";
		return str;
	}
}