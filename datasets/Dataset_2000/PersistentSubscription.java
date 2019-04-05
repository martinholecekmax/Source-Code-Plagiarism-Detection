@Entity(name="Subscriptions")
public class PersistentSubscription implements Subscription {
	@Basic
	private String subscriber;
	@Basic
	private String target;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getSubscriber() {
		return subscriber;
	}
	
	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}
	
	public String getTarget() {
		return target;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
}