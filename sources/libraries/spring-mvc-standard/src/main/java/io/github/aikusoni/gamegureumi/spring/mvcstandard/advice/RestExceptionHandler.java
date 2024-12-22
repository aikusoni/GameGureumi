package io.github.aikusoni.gamegureumi.spring.mvcstandard.advice;

import io.github.aikusoni.gamegureumi.spring.core.constants.ErrorCode;
import io.github.aikusoni.gamegureumi.spring.mvcstandard.model.view.GureumiResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler implements Ordered {
    private final CheckRoleAdvice roleCheckAdvice;

    @Override
    public int getOrder() {
        return roleCheckAdvice.getOrder() - 1;
    }

    @ExceptionHandler(io.github.aikusoni.gamegureumi.spring.core.exception.GureumiRuntimeException.class)
    public ResponseEntity<GureumiResponseBody<Void>> handle(io.github.aikusoni.gamegureumi.spring.core.exception.GureumiRuntimeException exception) {
        log.error("GureumiRuntimeException : ", exception);
        return GureumiResponseBody.<Void>error(exception.getErrorCode(), exception.getErrorAlias(), exception.getMessage())
                .toResponseEntity();
    }

    @ExceptionHandler(io.github.aikusoni.gamegureumi.spring.core.exception.GureumiException.class)
    public ResponseEntity<GureumiResponseBody<Void>> handle(io.github.aikusoni.gamegureumi.spring.core.exception.GureumiException exception) {
        log.error("GureumiException : ", exception);
        return GureumiResponseBody.<Void>error(exception.getErrorCode(), exception.getErrorAlias(), exception.getMessage())
                .toResponseEntity();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GureumiResponseBody<Void>> handle(RuntimeException exception) {
        log.error("RuntimeException : ", exception);
        return GureumiResponseBody.<Void>error(ErrorCode.INTERNAL_SERVER_ERROR, "REH999998", exception.getMessage())
                .toResponseEntity();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GureumiResponseBody<Void>> handle(Exception exception) {
        log.error("Exception : ", exception);
        return GureumiResponseBody.<Void>error(ErrorCode.INTERNAL_SERVER_ERROR, "REH999999", exception.getMessage())
                .toResponseEntity();
    }
}
