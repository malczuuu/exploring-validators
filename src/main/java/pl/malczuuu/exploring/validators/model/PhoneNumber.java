package pl.malczuuu.exploring.validators.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.malczuuu.exploring.validators.annotation.ValidPhoneNumber;

public class PhoneNumber {

  private final String number;

  @JsonCreator
  public PhoneNumber(@JsonProperty("number") String number) {
    this.number = number;
  }

  @ValidPhoneNumber
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return "(number='" + number + ")";
  }
}
