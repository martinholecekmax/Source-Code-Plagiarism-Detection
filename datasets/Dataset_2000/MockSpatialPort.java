public class MockSpatialPort implements Spatial {
    
    private MockServiceManager getManager() {
        return MockServiceManager.getInstance();
    }
    
    private void processExceptionBasic(Exception ex) throws SOLAFault, UnhandledFault {
        if (SOLAFault.class.isAssignableFrom(ex.getClass())) {
            throw (SOLAFault) ex;
        } else if (UnhandledFault.class.isAssignableFrom(ex.getClass())) {
            throw (UnhandledFault) ex;
        } else if (RuntimeException.class.isAssignableFrom(ex.getClass())) {
            throw (RuntimeException) ex;
        } else {
                                    throw new MockResponseException("Unable to convert the mocked response exception to "
                    + "recognized exception type: " + ex.getClass().getName());
        }
    }
    
    @Override
    public boolean checkConnection() {
        try {
            return getManager().getResponse(SpatialClient.CHECK_CONNECTION, Boolean.class, true);
        } catch (Exception ex) {
            if (RuntimeException.class.isAssignableFrom(ex.getClass())) {
                throw (RuntimeException) ex;
            } else {
                return false;
            }
        }
    }
    
    @Override
    public ResultForNavigationInfo getSpatialForNavigation(QueryForNavigation arg0)
            throws SOLAFault, UnhandledFault {
        ResultForNavigationInfo defaultResponse = new ResultForNavigationInfo();
        try {
            return getManager().getResponse(SpatialClient.GET_SPATIAL_FOR_NAVIGATION,
                    ResultForNavigationInfo.class, defaultResponse, arg0);
        } catch (Exception ex) {
            processExceptionBasic(ex);
            return null;
        }
    }
}