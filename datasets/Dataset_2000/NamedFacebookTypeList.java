package org.mule.module.facebook.types;
public class NamedFacebookTypeList implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Facebook
    private List<NamedFacebookType> data;
    public List<NamedFacebookType> getData()
    {
        return data;
    }
    public void setData(List<NamedFacebookType> data)
    {
        this.data = data;
    }
}