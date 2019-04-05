class SmIterator {
    boolean     search_states;
    sdInfo      searchSm;
    sdInfo      startSm;
    int         searchPos;
    SmContainer searchContainer;
    public SmIterator( sdInfo sd, boolean search_states ) {
        this.search_states = search_states;
        searchSm        = sd;
        startSm         = sd;
        searchPos       = 0;
        searchContainer = null;     }
                        public Object firstObj() {
        searchSm = startSm;
        searchContainer = search_states ? 
                           startSm.StateCont : startSm.TransCont;
        searchPos     = 0;
        return resultObj();
    }
    public Object resultObj() {
        while ( searchContainer != null &&
                searchPos >= searchContainer.v.size() ) {
            searchPos = 0;
            searchSm = searchSm.getSuper();
            if ( searchSm == null ) {
                searchContainer = null;
                break;
            }
            searchContainer = search_states ? 
                              searchSm.StateCont : searchSm.TransCont;
        }
        if ( searchContainer == null )
            return null;
        return searchContainer.v.get( searchPos );
    }
    public Object nextObj() {
        searchPos++;
        return resultObj();
    }
}