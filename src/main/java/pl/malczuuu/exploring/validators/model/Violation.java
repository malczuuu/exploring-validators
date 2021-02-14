package pl.malczuuu.exploring.validators.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Violation {

  private final String field;
  private final String message;

  @JsonCreator
  public Violation(@JsonProperty("field") String field, @JsonProperty("message") String message) {
    this.field = field;
    this.message = message;
  }

  @JsonProperty("field")
  public String getField() {
    return field;
  }

  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "(field=" + field + ", message=" + message + ")";
  }
}
