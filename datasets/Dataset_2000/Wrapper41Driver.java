public  class   Wrapper41Driver
{
                        private AutoloadedDriver40    _embedded;
    private Driver40            _driver40;
    private ClientDriver40      _netclient;
                        public Wrapper41Driver( Object wrapped ) throws Exception
    {
        if ( wrapped instanceof AutoloadedDriver40 ) { _embedded = (AutoloadedDriver40) wrapped; }
        else if ( wrapped instanceof Driver40 ) { _driver40 = (Driver40) wrapped; }
        else if ( wrapped instanceof ClientDriver40 ) { _netclient = (ClientDriver40) wrapped; }
        else { throw nothingWrapped( wrapped ); }
    }
                        public  Logger    getParentLogger() throws SQLException
    {
        if ( _embedded != null ) { return _embedded.getParentLogger(); }
        else if ( _driver40 != null ) { return _driver40.getParentLogger(); }
        else if ( _netclient != null ) { return _netclient.getParentLogger(); }
        else { throw nothingWrapped( null ); }
    }
                        public Driver   getWrappedObject() throws SQLException
    {
        if ( _embedded != null ) { return _embedded; }
        else if ( _driver40 != null ) { return _driver40; }
        else if ( _netclient != null ) { return _netclient; }
        else { throw nothingWrapped( null ); }
    }
                        private SQLException nothingWrapped( Object wrapped )
    {
        String  wrappedString = (wrapped == null ? "NULL" : wrapped.getClass().getName() );
        return new SQLException( "Nothing wrapped: " + wrappedString );
    }
}