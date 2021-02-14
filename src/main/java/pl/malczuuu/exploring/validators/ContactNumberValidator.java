package pl.malczuuu.exploring.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ValidContactNumber, String> {

  @Override
  public void initialize(ValidContactNumber contactNumber) {}

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null
        && value.matches("[0-9]+")
        && (value.length() > 8)
        && (value.length() < 14);
  }
}
