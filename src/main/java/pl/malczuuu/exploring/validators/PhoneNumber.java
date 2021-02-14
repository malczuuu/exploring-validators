package pl.malczuuu.exploring.validators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneNumber {

  private final String number;

  @JsonCreator
  public PhoneNumber(@JsonProperty("number") String number) {
    this.number = number;
  }

  @ValidContactNumber
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return "(number='" + number + ")";
  }
}
