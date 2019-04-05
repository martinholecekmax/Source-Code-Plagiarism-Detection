public class MinValidatorForString extends AbstractMinValidator<String> {
  public final boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    BigDecimal bigValue;
    try {
      bigValue = new BigDecimal(value);     } catch (NumberFormatException e) {
      return false;
    }
    return isValid(bigValue);
  }
}