public class TCPConnectivity extends ConnectivityCapability {
    static final long serialVersionUID = 1L;
    static final String DEFAULT_DESCRIPTION = "TCP/IP Connectivity";
    
    public static final String IPv6_NIC = "IPv6 NICs";
    
    public static final String IPv4_NIC = "IPv4 NICs";
    
    public TCPConnectivity() {
        this(DEFAULT_DESCRIPTION);
    }
    
    public TCPConnectivity(String description) {
        super(description);
        int ipv4Nics = 0;
        int ipv6Nics = 0;
        StringBuilder ipv4buff = new StringBuilder();
        StringBuilder ipv6buff = new StringBuilder();
        try {
            for(Enumeration en = NetworkInterface.getNetworkInterfaces();
                en.hasMoreElements();) {
                NetworkInterface nic = (NetworkInterface)en.nextElement();
                for(Enumeration en1=nic.getInetAddresses(); en1.hasMoreElements();) {
                    InetAddress addr = (InetAddress)en1.nextElement();                    
                    if(addr instanceof Inet6Address) {
                        if(ipv6Nics>0)
                            ipv6buff.append(", ");
                        ipv6buff.append(nic.getName());
                        ipv6Nics++;
                    } else {
                        if(ipv4Nics>0)
                            ipv4buff.append(", ");
                        ipv4buff.append(nic.getName());
                        ipv4Nics++;
                    }
                }
            }
            define(IPv4_NIC, ipv4buff.toString());
            if(ipv6Nics>0)
                define(IPv6_NIC, ipv6buff.toString());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Getting NetworkInterfaces", e);
        }
    }
}