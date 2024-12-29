package io.github.aikusoni.gamegureumi.spring.testserver.controller;

import io.github.aikusoni.gamegureumi.spring.core.common.MessageCode;
import io.github.aikusoni.gamegureumi.spring.mvcstandard.advice.CheckRole;
import io.github.aikusoni.gamegureumi.spring.mvcstandard.model.view.GureumiResponseBody;
import io.github.aikusoni.gamegureumi.spring.testserver.constants.TestMessageCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.aikusoni.gamegureumi.spring.testserver.constants.TestMessageCode.HAS_PERMISSION;

@Slf4j
@RestController
@RequestMapping("/v1/test")
@RequiredArgsConstructor
public class TestController {

    @Operation(parameters = {
            @Parameter(name = "X-Roles", in = ParameterIn.HEADER, schema = @Schema(type = "string"))
    })
    @CheckRole("admin")
    @GetMapping("/role/admin")
    public ResponseEntity<GureumiResponseBody<String>> admin(
    ) throws Exception {
        return GureumiResponseBody
                .ok("ok", HAS_PERMISSION)
                .toResponseEntity();
    }

    @Operation(parameters = {
            @Parameter(name = "X-Roles", in = ParameterIn.HEADER, schema = @Schema(type = "string"))
    })
    @CheckRole("item-registration")
    @GetMapping("/role/item-registration")
    public ResponseEntity<GureumiResponseBody<String>> itemRegistration(
    ) throws Exception {
        return GureumiResponseBody
                .ok("ok", HAS_PERMISSION)
                .toResponseEntity();
    }

    @Operation(parameters = {
            @Parameter(name = "X-Roles", in = ParameterIn.HEADER, schema = @Schema(type = "string"))
    })
    @CheckRole("item-sell")
    @GetMapping("/role/item-sell")
    public ResponseEntity<GureumiResponseBody<String>> itemSell(
    ) throws Exception {
        return GureumiResponseBody
                .ok("ok", HAS_PERMISSION)
                .toResponseEntity();
    }

    @Operation(parameters = {
            @Parameter(name = "X-Roles", in = ParameterIn.HEADER, schema = @Schema(type = "string"))
    })
    @CheckRole("item-buy")
    @GetMapping("/role/item-buy")
    public ResponseEntity<GureumiResponseBody<String>> itemBuy(
    ) throws Exception {
        return GureumiResponseBody
                .ok("ok", HAS_PERMISSION)
                .toResponseEntity();
    }

    @Operation(parameters = {
            @Parameter(name = "X-Roles", in = ParameterIn.HEADER, schema = @Schema(type = "string"))
    })
    @CheckRole("item-stat")
    @GetMapping("/role/item-stat")
    public ResponseEntity<GureumiResponseBody<String>> itemStat(
    ) throws Exception {
        return GureumiResponseBody
                .ok("ok", HAS_PERMISSION)
                .toResponseEntity();
    }

    @Operation(parameters = {
            @Parameter(name = "X-Roles", in = ParameterIn.HEADER, schema = @Schema(type = "string"))
    })
    @GetMapping("/role/everyone")
    public ResponseEntity<GureumiResponseBody<String>> everyone(
    ) throws Exception {
        return GureumiResponseBody
                .ok("ok", HAS_PERMISSION)
                .toResponseEntity();
    }
}
