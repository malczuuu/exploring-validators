package pl.malczuuu.exploring.validators.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

  private static final String PATTERN = "[0-9]+";
  private static final int MIN_EXC = 8;
  private static final int MAX_EXC = 14;
  private static final String MESSAGE =
      "must match \""
          + PATTERN
          + "\" and have length between "
          + MIN_EXC
          + " and "
          + MAX_EXC
          + " (both exclusive)";

  @Override
  public void initialize(ValidPhoneNumber constraintAnnotation) {}

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    context.disableDefaultConstraintViolation();

    if (value == null) {
      return true;
    }

    boolean valid = value.matches(PATTERN);
    valid &= value.length() > MIN_EXC;
    valid &= value.length() < MAX_EXC;

    if (!valid) {
      context.buildConstraintViolationWithTemplate(MESSAGE).addConstraintViolation();
    }
    return valid;
  }
}
