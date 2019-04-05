@Aspect
@Component
public class TransitDataServiceExceptionInterceptor {
  private final Logger _log = LoggerFactory.getLogger(TransitDataServiceExceptionInterceptor.class);
  @Around("execution(* org.onebusaway.transit_data_federation.impl.federated.TransitDataServiceImpl.*(..))")
  public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
    try {
      return pjp.proceed();
    } catch (ServiceException ex) {
      throw ex;
    } catch (Throwable ex) {
      _log.error("error executing TransitDataService method", ex);
      throw new ServiceException(ex);
    }
  }
}