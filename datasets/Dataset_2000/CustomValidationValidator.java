public class CustomValidationValidator implements ConstraintValidator<CustomValidation, String> {
    @Autowired
    private InjectableBean injectableBean;
    public void initialize(CustomValidation constraintAnnotation) {
    }
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return injectableBean.isEmailAddressUnique(email);
    }
}