package io.github.aikusoni.gamegureumi.spring.mvcstandard.advice;

import io.github.aikusoni.gamegureumi.spring.mvcstandard.model.view.GureumiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.aikusoni.gamegureumi.spring.mvcstandard.constants.WebMvcTestMessageCode.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/check-role")
public class CheckRoleTestsController {
    @CheckRole("ADMIN")
    @RequestMapping(method = {POST, GET}, path = "/admin", produces = "application/json")
    public ResponseEntity<GureumiResponseBody<String>> admin() {
        return GureumiResponseBody.ok("OK", ADMIN_PERMISSION)
                .toResponseEntity();
    }

    @CheckRole("USER")
    @RequestMapping(method = {POST, GET}, path = "/user", produces = "application/json")
    public ResponseEntity<GureumiResponseBody<String>> user() {
        return GureumiResponseBody.ok("OK", USER_PERMISSION.getMessage())
                .toResponseEntity();
    }
}
