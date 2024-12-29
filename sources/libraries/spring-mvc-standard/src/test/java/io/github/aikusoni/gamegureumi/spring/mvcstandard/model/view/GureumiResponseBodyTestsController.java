package io.github.aikusoni.gamegureumi.spring.mvcstandard.model.view;

import io.github.aikusoni.gamegureumi.spring.core.constants.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.aikusoni.gamegureumi.spring.mvcstandard.constants.WebMvcTestMessageCode.WITH_MESSAGE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/gg-response-body")
public class GureumiResponseBodyTestsController {
    @RequestMapping(method = {POST, GET}, path = "/only-ok", produces = "application/json")
    public ResponseEntity<GureumiResponseBody<String>> onlyOk() {
        return GureumiResponseBody.ok("OK")
                .toResponseEntity();
    }

    @RequestMapping(method = {POST, GET}, path = "/with-message-ok", produces = "application/json")
    public ResponseEntity<GureumiResponseBody<String>> withMessageOk() {
        return GureumiResponseBody.ok("OK", WITH_MESSAGE)
                .toResponseEntity();
    }

    @RequestMapping(method = {POST, GET}, path = "/with-message-error", produces = "application/json")
    public ResponseEntity<GureumiResponseBody<Void>> withMessageError() {
        return GureumiResponseBody.<Void>error(ErrorCode.INTERNAL_SERVER_ERROR,"ART-0000001", WITH_MESSAGE)
                .toResponseEntity();
    }
}
