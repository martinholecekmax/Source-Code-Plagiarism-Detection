@Target({TYPE, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ChangedPasswordValidator.class)
public @interface ChangedPassword {
    
    String message() default "{validation.incorrectCurrentPassword}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}