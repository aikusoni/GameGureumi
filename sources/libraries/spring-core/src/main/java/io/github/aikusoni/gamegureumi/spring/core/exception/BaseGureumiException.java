package io.github.aikusoni.gamegureumi.spring.core.exception;

import io.github.aikusoni.gamegureumi.spring.core.common.BaseErrorCode;

public interface BaseGureumiException {
    BaseErrorCode getErrorCode();
    String getErrorAlias();
    String getMessage();
}
