package io.github.aikusoni.gamegureumi.spring.core.constants;

import io.github.aikusoni.gamegureumi.spring.core.common.BaseErrorCode;
import lombok.Getter;

/**
 * 각 앱별 자체 예외 코드는 10000번대 이상의 errorCode를 사용해야한다.
 */
@Getter
public enum CustomErrorCodeExample implements BaseErrorCode {
    CUSTOM_ERROR_CODE(20000, 500)
    , OTHER_PERSONS_PROPERTY(20001, 403);
    ;

    final int errorCode;
    final int statusCode;

    CustomErrorCodeExample(int errorCode, int statusCode) {
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }
}
