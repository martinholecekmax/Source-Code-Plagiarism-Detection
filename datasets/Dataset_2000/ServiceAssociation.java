@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceAssociation {
    
    String name() default "";
    
    Class serviceType() ;   
    
    AssociationType type() default AssociationType.USES;
    
    Class proxy() default AssociationProxySupport.class;
    
    Class strategy() default FailOver.class;
    
    boolean eager() default false;
    
    long timeout() default 0;
    
    TimeUnit timeoutUnits() default TimeUnit.SECONDS;
}