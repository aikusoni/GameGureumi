package io.github.aikusoni.gamegureumi.spring.mvcstandard.config;

import io.github.aikusoni.gamegureumi.spring.mvcstandard.model.view.GureumiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.aikusoni.gamegureumi.spring.mvcstandard.constants.WebMvcTestMessageCode.LOCALE_CONFIG_TEST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/locale-config")
public class LocaleConfigTestsController {
    @RequestMapping(method = {POST, GET}, path = "/test", produces = "application/json")
    public ResponseEntity<GureumiResponseBody<String>> test() {
        return GureumiResponseBody.ok("OK", LOCALE_CONFIG_TEST)
                .toResponseEntity();
    }
}
