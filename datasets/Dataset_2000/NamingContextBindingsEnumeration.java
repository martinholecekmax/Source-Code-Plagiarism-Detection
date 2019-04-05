public class NamingContextBindingsEnumeration 
    implements NamingEnumeration {
        public NamingContextBindingsEnumeration(Iterator entries, Context ctx) {
    	iterator = entries;
        this.ctx = ctx;
    }
        
    protected Iterator iterator;
    
    private Context ctx;
        
    public Object next()
        throws NamingException {
        return nextElementInternal();
    }
    
    public boolean hasMore()
        throws NamingException {
        return iterator.hasNext();
    }
    
    public void close()
        throws NamingException {
    }
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }
    public Object nextElement() {
        try {
            return nextElementInternal();
        } catch (NamingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    private Object nextElementInternal() throws NamingException {
        NamingEntry entry = (NamingEntry) iterator.next();
                if (entry.type == NamingEntry.REFERENCE
                || entry.type == NamingEntry.LINK_REF) {
            try {
                                ctx.lookup(new CompositeName(entry.name));
            } catch (NamingException e) {
                throw e;
            } catch (Exception e) {
                NamingException ne = new NamingException(e.getMessage());
                ne.initCause(e);
                throw ne;
            }
        }
        return new Binding(entry.name, entry.value.getClass().getName(), 
                           entry.value, true);
    }
}