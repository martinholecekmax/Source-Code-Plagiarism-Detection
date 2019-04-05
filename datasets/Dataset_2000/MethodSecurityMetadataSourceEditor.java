public class MethodSecurityMetadataSourceEditor extends PropertyEditorSupport 
{
    
    public void setAsText(String text) throws IllegalArgumentException 
    {
        try
        {
            Map<String, List<ConfigAttribute>> mappings = new LinkedHashMap<String, List<ConfigAttribute>>();
            if (text != null)
            {
                text = text.trim();
                if (text.length() > 0)
                {
                    Properties props = new Properties();
                    props.load(new StringReader(text));
                    for (Map.Entry entry : props.entrySet())
                    {
                        String methodName = (String) entry.getKey();
                        List<ConfigAttribute> cfgAttrs = new ArrayList<ConfigAttribute>();
                        String atrs = (String) entry.getValue();
                        String[] attrArray = atrs.split(",");
                        for (String attr : attrArray)
                        {
                            attr = attr.trim();
                            if (attr.length() > 0)
                            {
                                cfgAttrs.add(new SecurityConfig(attr));
                            }
                        }
                        mappings.put(methodName, cfgAttrs);
                    }
                }
                setValue(new MapBasedMethodSecurityMetadataSource(mappings));
            }
        }
        catch(Exception ex)
        {
            throw new IllegalArgumentException(MessageFormat.format("Error parsing {0}", text), ex);
        }
    }
}