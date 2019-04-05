public class CDOChangeSubscriptionAdapter extends AdapterImpl
{
  private CDOView view;
  private CDOAdapterPolicy policy = new CDOAdapterPolicy()
  {
    public boolean isValid(EObject eObject, Adapter adapter)
    {
      return adapter == CDOChangeSubscriptionAdapter.this;
    }
  };
  private Set<CDOObject> notifiers = new HashSet<CDOObject>();
  public CDOChangeSubscriptionAdapter(CDOView view)
  {
    this.view = view;
    view.options().addChangeSubscriptionPolicy(policy);
  }
  public void dispose()
  {
    reset();
    view.options().removeChangeSubscriptionPolicy(policy);
    view = null;
  }
  public CDOView getView()
  {
    return view;
  }
  public Set<CDOObject> getNotifiers()
  {
    return notifiers;
  }
  public void attach(CDOObject notifier)
  {
    if (notifiers.add(notifier))
    {
      notifier.eAdapters().add(this);
    }
  }
  public void reset()
  {
    for (CDOObject notifier : notifiers)
    {
      notifier.eAdapters().remove(this);
    }
    notifiers.clear();
  }
}