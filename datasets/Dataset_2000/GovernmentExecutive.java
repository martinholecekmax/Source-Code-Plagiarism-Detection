@Entity
@Table(name = "government_executive")
public class GovernmentExecutive extends Role {
	@Column
	private String charge;
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
}