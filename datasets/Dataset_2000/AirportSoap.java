@WebService(serviceName="airport", portName="airportSoap", targetNamespace = "http:@XmlSeeAlso({ObjectFactory.class})
public interface AirportSoap {
    @WebResult(name = "getAirportInformationByISOCountryCodeResult", targetNamespace = "http:    @RequestWrapper(localName = "getAirportInformationByISOCountryCode", targetNamespace = "http:    @WebMethod(action = "http:    @ResponseWrapper(localName = "getAirportInformationByISOCountryCodeResponse", targetNamespace = "http:    public java.lang.String getAirportInformationByISOCountryCode(
        @WebParam(name = "CountryAbbrviation", targetNamespace = "http:        java.lang.String countryAbbrviation
    );
}