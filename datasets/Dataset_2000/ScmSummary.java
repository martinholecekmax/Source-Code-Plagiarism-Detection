@SuppressWarnings("serial")
public class ScmSummary implements Serializable {
	private Date date;
	private Long amount;
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getAmount() {
		return amount;
	}
}