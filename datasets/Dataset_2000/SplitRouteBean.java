public class SplitRouteBean
{
	private AirportBean m_from;
	private AirportBean m_to;
	private ArrayList m_flights;
	public SplitRouteBean() {
		m_flights = new ArrayList();
	}
	public void setFrom(AirportBean from) {
		m_from = from;
	}
	public AirportBean getFrom() {
		return m_from;
	}
	public void setTo(AirportBean to) {
		m_to = to;
	}
	public AirportBean getTo() {
		return m_to;
	}
	public ArrayList getFlights() {
		return m_flights;
	}
	public void addFlight(SplitFlightBean flight) {
		m_flights.add(flight);
	}
	public boolean equals(Object obj) {
		if (obj instanceof SplitRouteBean) {
			SplitRouteBean compare = (SplitRouteBean)obj;
			return Utils.equalAirports(m_to, compare.m_to) && 
				Utils.equalAirports(m_from, compare.m_from) &&
				Utils.equalLists(m_flights, compare.m_flights);
		} else {
			return false;
		}
	}
}