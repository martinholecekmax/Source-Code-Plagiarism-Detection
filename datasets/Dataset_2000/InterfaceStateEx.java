class InterfaceStateEx extends InterfaceState
{
    protected State createChildState( StartTagInfo tag )
    {
        RELAXCoreIslandSchemaReader reader = (RELAXCoreIslandSchemaReader)this.reader;
        if(!tag.namespaceURI.equals(RELAXCoreIslandSchemaReader.RELAXCoreNamespace))    return null;
        if(tag.localName.equals("div"))        return new InterfaceStateEx();
        RELAXModule module = reader.getModule();
        if(tag.localName.equals("export"))
        {
            final String role = tag.getAttribute("role");
            if(role!=null)
            {
                module.attPools.getOrCreate(role).exported = true;
                return new ChildlessState();
            }
                    }
        if(tag.localName.equals("hedgeExport"))
        {
            final String label = tag.getAttribute("label");
            if(label==null)
                reader.reportError(RELAXCoreIslandSchemaReader.ERR_MISSING_ATTRIBUTE,"hedgeExport","label");
                            else
                module.hedgeRules.getOrCreate(label).exported = true;
            return new ChildlessState();
        }
        return super.createChildState(tag);
    }
}