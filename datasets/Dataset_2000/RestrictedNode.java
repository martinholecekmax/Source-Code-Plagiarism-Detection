interface RestrictedNode 
{
    public RestrictedNode serial(RestrictedNode node);
    public int match(ServerNotification notification);
    public boolean contains(Class clazz, int action);
    public boolean isExhausted();
    
    public RestrictedNode getAnyRemaining();
    Class getNotificationClass();
}