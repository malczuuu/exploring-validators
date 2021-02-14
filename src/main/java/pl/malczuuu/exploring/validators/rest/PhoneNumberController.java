package pl.malczuuu.exploring.validators.rest;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.malczuuu.exploring.validators.model.PhoneNumber;

@Validated
@RestController
@RequestMapping("/api/phone-numbers")
public class PhoneNumberController {

  private static final Logger log = LoggerFactory.getLogger(PhoneNumberController.class);

  @PostMapping
  public PhoneNumber post(@RequestBody @Valid PhoneNumber phoneNumber) {
    log.info("Processed phoneNumber={}", phoneNumber);
    return phoneNumber;
  }
}
