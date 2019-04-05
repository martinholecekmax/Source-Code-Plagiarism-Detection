public class IncomingCallFactoryImpl implements IncomingCallFactory {
  ExecutionContext _context;
  @Override
  public void init(ExecutionContext context, Map<String, String> properties) throws Exception {
    _context = context;
  }
  @Override
  public void destroy() {
  }
  @Override
  public IncomingCall createIncomingCall(SipServletRequest request) {
    return new SIPIncomingCall(_context, request);
  }
  @Override
  public String getName() {
    return IncomingCallFactory.class.getName();
  }
}