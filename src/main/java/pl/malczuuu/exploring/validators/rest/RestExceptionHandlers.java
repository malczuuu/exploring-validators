package pl.malczuuu.exploring.validators.rest;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import pl.malczuuu.exploring.validators.model.Violation;
import pl.malczuuu.exploring.validators.model.ViolationsReport;

/**
 * Handle exceptions involving validation to produce nice-looking application/problem+json response.
 */
@RestControllerAdvice
public class RestExceptionHandlers {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ViolationsReport> handle(
      ConstraintViolationException e, WebRequest request) {
    List<Violation> violations = extractViolations(e);
    return respond(violations);
  }

  private List<Violation> extractViolations(ConstraintViolationException e) {
    return e.getConstraintViolations().stream()
        .map(v -> new Violation(v.getPropertyPath().toString(), v.getMessage()))
        .collect(Collectors.toList());
  }

  private ResponseEntity<ViolationsReport> respond(List<Violation> violations) {
    return ResponseEntity.badRequest()
        .contentType(MediaType.APPLICATION_PROBLEM_JSON)
        .body(new ViolationsReport(violations));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ViolationsReport> handle(
      MethodArgumentNotValidException e, WebRequest request) {
    List<Violation> violations = extractViolations(e);
    return respond(violations);
  }

  private List<Violation> extractViolations(MethodArgumentNotValidException e) {
    return e.getBindingResult().getFieldErrors().stream()
        .map(f -> new Violation(f.getField(), f.getDefaultMessage()))
        .collect(Collectors.toList());
  }
}
