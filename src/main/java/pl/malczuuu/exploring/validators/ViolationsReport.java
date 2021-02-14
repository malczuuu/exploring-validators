package pl.malczuuu.exploring.validators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViolationsReport {

  private final String type;
  private final String title;
  private final int status;
  private final String detail;
  private final List<Violation> violations;

  @JsonCreator
  public ViolationsReport(
      @JsonProperty("type") String type,
      @JsonProperty("title") String title,
      @JsonProperty("status") int status,
      @JsonProperty("detail") String detail,
      @JsonProperty("violations") List<Violation> violations) {
    this.type = type;
    this.title = title;
    this.status = status;
    this.detail = detail;
    this.violations = new ArrayList<>(violations);
  }

  public ViolationsReport(List<Violation> violations) {
    this("about::blank", "Bad Request", 400, "Constraint violations", violations);
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("status")
  public int getStatus() {
    return status;
  }

  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  @JsonProperty("violation")
  public List<Violation> getViolations() {
    return Collections.unmodifiableList(violations);
  }

  @Override
  public String toString() {
    String[] formattedViolations = new String[violations.size()];
    for (int i = 0; i < violations.size(); ++i) {
      formattedViolations[i] = "violations[" + i + "]=" + violations.get(i);
    }
    return "(type="
        + type
        + ", title="
        + title
        + ", status="
        + status
        + ", detail="
        + detail
        + ", "
        + String.join(", ", formattedViolations)
        + ")";
  }
}
