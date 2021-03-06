package pl.malczuuu.exploring.validators.rest;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Just redirects from home page to Swagger UI page for simplicity. */
@RestController
@RequestMapping(path = "/")
public class RootController {

  @GetMapping
  public void redirectToSwaggerUi(HttpServletResponse httpServletResponse) {
    httpServletResponse.setHeader("Location", "/swagger-ui/index.html");
    httpServletResponse.setStatus(302);
  }
}
