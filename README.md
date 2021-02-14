# Exploring Validators

Test implementation of custom validators in `javax.validation` and `hibernate-validator` style.

This repository holds a simple [`ValidPhoneNumber`][ValidPhoneNumber.java] annotation, being bound
with [`PhoneNumberValidator`][PhoneNumberValidator.java] validator class. It shows how to attach a
custom message to field validation.

HTTP server starts at port `8777`. Browse [Swagger UI][SwaggerUI] to test validation via REST API
endpoint.

[ValidPhoneNumber.java]: src/main/java/pl/malczuuu/exploring/validators/annotation/ValidPhoneNumber.java
[PhoneNumberValidator.java]: src/main/java/pl/malczuuu/exploring/validators/annotation/PhoneNumberValidator.java
[SwaggerUI]: http://localhost:8777
