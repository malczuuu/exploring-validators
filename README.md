# Exploring Validators

Test implementation of custom validators in `javax.validation` and `hibernate-validator` style.

This repository holds a simple [`ValidPhoneNumber`][ValidPhoneNumber.java] annotation, being bound
with [`PhoneNumberValidator`][PhoneNumberValidator.java] validator class. It shows how to attach a
custom message to field validation.

HTTP server starts at port `8777`. Browse [Swagger UI][SwaggerUI] to test validation via REST API
endpoint.

---

## Conclusions

* Disabling default message skips the usage of a pre-defined one inside annotation declaration.

  ```java
  public @interface ValidPhoneNumber {
  
    String message() default "";
  
    // ...
  }
  ```

* In order to add a custom message, use `context` parameter from `isValid` function in validator
  implementation

  ```java
  public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    // ...

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      context.disableDefaultConstraintViolation();

      // ...

      context.buildConstraintViolationWithTemplate("is not valid").addConstraintViolation();
  
      // ...
    }
  }
  ```

  **Note** that field is being automatically read from validated class definition.

[ValidPhoneNumber.java]: src/main/java/pl/malczuuu/exploring/validators/annotation/ValidPhoneNumber.java
[PhoneNumberValidator.java]: src/main/java/pl/malczuuu/exploring/validators/annotation/PhoneNumberValidator.java
[SwaggerUI]: http://localhost:8777
