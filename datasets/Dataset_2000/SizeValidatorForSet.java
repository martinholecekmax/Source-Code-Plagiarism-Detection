public class SizeValidatorForSet implements ConstraintValidator<Size, Set> {
	public void initialize(Size constraintAnnotation) {
	}
	public boolean isValid(Set object, ConstraintValidatorContext constraintContext) {
		return true;
	}
}